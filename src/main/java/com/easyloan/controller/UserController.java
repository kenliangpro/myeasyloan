package com.easyloan.controller;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.easyloan.bean.Msg;
import com.easyloan.bean.User;
import com.easyloan.bean.UserInfo;
import com.easyloan.service.UserService;
import com.easyloan.utils.CookieUtils;
import com.easyloan.utils.FormatDate;
import com.easyloan.utils.Md5Utils;
import com.easyloan.utils.UUIDUtils;
import com.google.gson.Gson;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserService userService;

	Gson gson = new Gson();

	@Value("${web.upload-path}")
	private String imgPath;

	/**
	 * 用户注册
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Msg registerUser(@Valid User user, HttpServletRequest request, BindingResult result) {
		// 发送短信验证码
		if (!user.getCode().equals(request.getSession().getAttribute("mobile_code"))) {
			return Msg.fail().add("errorMsg", "手机验证码不正确");
		}
		if (!user.getConpassword().equals(user.getPassword())) {
			return Msg.fail().add("errorMsg", "输入密码不一致");
		}
		if (isExist(user.getUsername())) {
			return Msg.fail().add("errorMsg", "用户名已经存在");
		}
		user.setId(UUIDUtils.toPrimaryKey());
		user.setPassword(Md5Utils.encode(user.getPassword()));
		user.setRegisterTime(FormatDate.formatDate(new Date()));
		user.setIsDel(0);
		user.setIsShield(0);
		userService.saveUser(user);
		return Msg.success();

	}

	/**
	 * 发送手机短信验证码
	 * @param username
	 * @param request
	 * @return
	 */
	@RequestMapping("/sendcode/{username}")
	@ResponseBody
	public Msg sendPhoneValidateCode(@PathVariable("username") String username, HttpServletRequest request) {
		userService.sendMsg(username, request);
		return Msg.success();

	}

	/**
	 * 判断用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	private boolean isExist(String username) {
		return userService.isExist(username);
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public Msg loginUser(HttpServletRequest request, HttpServletResponse response, User user) {
		// 验证码验证
		if (!request.getSession().getAttribute("code").equals(user.getCode())) {
			return Msg.fail().add("errorMsg", "验证码错误");
		}
		user.setPassword(Md5Utils.getMD5Pwd(user.getPassword()));
		// 数据齐全的user
		User userFull = userService.login(user);
		if (userFull != null) {
			String userJson = gson.toJson(userFull);
			CookieUtils.setCookie(request, response, CookieUtils.USER_TOKEN, userJson, -1, "UTF-8");
			request.getSession().setAttribute("user", userFull);
			return Msg.success().add("user", userService.selectUserWithInfoByKey(userFull.getId()));
		} else {
			return Msg.fail().add("errorMsg", "用户名或密码错误");
		}
	}

	/**
	 * 有modelAttribute标记的方法，会在每个目标方法执行之前，都会被调用
	 * 
	 * @param request
	 * @param map
	 */
	@ModelAttribute
	public void getInfo(HttpServletRequest request, Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			String infoId = user.getUserinfoId();
			if (infoId != null) {
				UserInfo info = userService.selectInfoByKey(infoId);
				map.put("info", info);
			}
		}
	}

	/**
	 * 增加用户信息
	 * 
	 * @param request
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value = "/perfectInfo")
	@ResponseBody
	public Msg perfectInfo(HttpServletRequest request, @ModelAttribute("info") UserInfo userinfo) {
		User user = (User) request.getSession().getAttribute("user");
		// 1.判断user是否添加信息
		// 2.如果不存在，进入插入操作
		// 3.如果存在，进行更新操作
		if (user.getUserinfoId() != null) {
			if (userService.updateInfo(userinfo)) {
				return Msg.success();
			}
		} else {
			userinfo.setId(UUIDUtils.toPrimaryKey());
			if (userService.saveInfo(userinfo, user)) {
				return Msg.success();
			}
		}
		return Msg.fail().add("errorMsg", "更改用户信息出错!");
	}

	@RequestMapping(value = "uploadHeaderImg", method = RequestMethod.POST)
	@ResponseBody
	public Msg uploadHeaderImg(@RequestParam("headerImgFile") MultipartFile headerImgFile, HttpServletRequest request,
			@ModelAttribute("info") UserInfo userinfo) {
		//从session域中拿出已经登录的user
		User user = (User) request.getSession().getAttribute("user");
		//判断头像文件是否为空
		if (headerImgFile.isEmpty()) {
			return Msg.fail().add("errorMsg", "文件为空");
		}
		String fileName = headerImgFile.getOriginalFilename();
		File dest = new File(this.imgPath + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			// 如果已经创建了userinfo，即user中的userinfo_id不为空
			if (userinfo.getId() != null) {
				headerImgFile.transferTo(dest);
				userinfo.setHeaderImg(dest.getName());
				userService.updateInfo(userinfo);
				return Msg.success().add("imgSrc", dest.getName());
			} else {
				// 未创建userinfo
				userinfo.setId(UUIDUtils.toPrimaryKey());
				userinfo.setHeaderImg(dest.getName());
				if (userService.saveInfo(userinfo, user)) {
					return Msg.success().add("imgSrc", dest.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Msg.fail().add("errorMsg", "上传失败");
		}
		return Msg.fail().add("errorMsg", "上传失败");
	}

	/**
	 * 忘记密码
	 * 
	 * @param username
	 * @param request
	 * @return
	 */
	@RequestMapping("/forgetPassword")
	@ResponseBody
	public Msg forgetPassword(@RequestParam("username") String username, HttpServletRequest request) {
		//如果用户名存在
		if (userService.selectUserByUsername(username) != null) {
			//发送手机短信验证码
			userService.sendMsg(username, request);
			//通过username（手机号码）查询该user信息
			User user_forget_pwd = userService.selectUserByUsername(username);
			//把user信息放进session域中
			request.getSession().setAttribute("user_forget_pwd", user_forget_pwd);
			return Msg.success();
		}
		return Msg.fail().add("errorMsg", "用户名不存在");
	}

	/**
	 * 忘记密码-修改密码(忽略旧密码)
	 * 
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findpassword")
	@ResponseBody
	public Msg findPassword(@RequestParam("password") String password, @RequestParam("code") String code,
			HttpServletRequest request) {
		//从session拿出用户信息
		User user = (User) request.getSession().getAttribute("user_forget_pwd");
		//从session域拿出手机短信验证码
		String forget_code = (String) request.getSession().getAttribute("mobile_code");
		//如果验证码不想等
		if(!code.equals(forget_code)) {
			return Msg.fail().add("errorMsg", "手机验证码错误");
		}
		//设置新的密码
		user.setPassword(Md5Utils.encode(password));
		//更新新的密码
		if (userService.updateUserByKey(user)) {
			return Msg.success();
		}
		return Msg.fail().add("errorMsg", "更改密码失败");
	}

}
