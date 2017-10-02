package com.easyloan.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easyloan.bean.SafetyQuestion;
import com.easyloan.bean.UserInfo;
import com.easyloan.dao.SafetyQuestionMapper;
import com.easyloan.dao.UserInfoMapper;
import com.easyloan.dao.UserMapper;
import com.easyloan.dto.*;
import com.easyloan.enums.UserStateEnum;
import com.easyloan.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.easyloan.bean.User;
import com.easyloan.service.UserService;
import com.easyloan.utils.Md5Utils;
import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SafetyQuestionMapper safetyInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserMapper userMapper;


    Gson gson = new Gson();


    /**
     * 用户登录
     *
     * @param userDto
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserResult userLogin(@RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        UserResult userResult = null;
        //获取session中的验证码
        String session_verification_code = (String) request.getSession().getAttribute("code");
        userDto.setSession_verification_code(session_verification_code);

        userResult = userService.userLogin(userDto);
        if (userResult.getData() != null) {
            //放进session
            request.getSession().setAttribute("session_user", userResult.getData());
            //放进cookie
            CookieUtils.setCookie(request, response, CookieUtils.USER_TOKEN, gson.toJson(userResult.getData()), -1, "UTF-8");
        }
        return userResult;
    }

    /**
     * 用户注册
     *
     * @param userDto
     * @param session
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public UserResult userRegister(@RequestBody UserDto userDto, HttpSession session) {
        UserResult userResult = null;
        userDto.setSession_verification_code((String) session.getAttribute("mobile_code"));
        userResult = userService.userRegister(userDto);
        return userResult;
    }


    /**
     * 发送手机短信验证码
     *
     * @param username
     * @param session
     * @return
     */
    @RequestMapping(value = "/sendcode/{username}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg sendPhoneValidateCode(@PathVariable("username") String username, HttpSession session) {
        Msg msg = null;
        msg = userService.sendMoblieVerificationCode(username);
        if (msg.getExtraData().get("mobile_code") != null) {
            session.setAttribute("mobile_code", msg.getExtraData().get("mobile_code"));
        }
        return msg;

    }

    /**
     * 查看用户安全信息
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/checkSafetyInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SafetyInfoResult selectSafetyInfo(HttpSession session) {
        Msg msg = null;
        User user = (User) session.getAttribute("session_user");

        if (user != null) {
            SafetyQuestion safetyInfo = safetyInfoMapper.selectByPrimaryKey(user.getSafetyQuestionId());
            if (safetyInfo != null) {
                return new SafetyInfoResult(UserStateEnum.SUCCESSCHECK, safetyInfo);
            } else {
                return new SafetyInfoResult(UserStateEnum.FAILCHECK);
            }
        }
        return new SafetyInfoResult(UserStateEnum.UNLOGIN);
    }

    /**
     * 查看用户信息
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/checkUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserInfoResult selectUserInfo(HttpSession session) {
        Msg msg = null;
        User user = (User) session.getAttribute("session_user");
        if (user != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(user.getUserinfoId());
            if (userInfo != null) {
                return new UserInfoResult(UserStateEnum.SUCCESSCHECK, userInfo);
            }
        }
        return new UserInfoResult(UserStateEnum.UNLOGIN);
    }



    /**
     * 有modelAttribute标记的方法，会在每个目标方法执行之前，都会被调用
     *
     * @param session
     * @param map
     */
    @ModelAttribute
    public void getInfo(HttpSession session, Map<String, Object> map) {
        User user = (User) session.getAttribute("session_user");
        if (user != null) {
            String infoId = user.getUserinfoId();
            if (infoId != null) {
                UserInfo info = userInfoMapper.selectByPrimaryKey(infoId);
                map.put("userInfo", info);
            }
        }
    }

    /**
     * 有modelAttribute标记的方法，会在每个目标方法执行之前，都会被调用
     *
     * @param session
     * @param map
     */
    @ModelAttribute
    public void getSafetyInfo(HttpSession session, Map<String, Object> map) {
        User user = (User) session.getAttribute("session_user");
        if (user != null) {
            String safetyInfoId = user.getSafetyQuestionId();
            if (safetyInfoId != null) {
                SafetyQuestion safetyInfo = safetyInfoMapper.selectByPrimaryKey(safetyInfoId);
                map.put("safetyInfo", safetyInfo);
            }
        }
    }

    /**
     * 增加用户信息
     *
     * @param userinfo
     * @return
     */
    @RequestMapping(value = "/perfectInfo", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg perfectInfo(@ModelAttribute("userInfo") UserInfo userinfo) {
        Msg msg = null;
        msg = userService.perfectUserInfo(userinfo);
        return msg;
    }

    /**
     * 用户实名认证
     *
     * @param headerImgFiles
     * @param realName
     * @param idNumber
     * @param userinfo
     * @return
     */
    @RequestMapping(value = "/userCertification", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg userCertification(@RequestParam("headerImgFiles") MultipartFile[] headerImgFiles,
                                 @RequestParam("realName") String realName,
                                 @RequestParam("idNumber") String idNumber,
                                 @ModelAttribute("userInfo") UserInfo userinfo) {
        Msg msg = null;
        msg = userService.userCertification(idNumber, headerImgFiles, realName, userinfo);
        return msg;
    }

    /**
     * 增加用户安全信息
     *
     * @param session
     * @param safetyInfo
     * @return
     */
    @RequestMapping(value = "/perfectSafetyInfo", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg perfectSecurityInfo(HttpSession session, @ModelAttribute("safetyInfo") SafetyQuestion safetyInfo) {
        User user = (User) session.getAttribute("session_user");
        Msg msg = null;
        msg = userService.perfectSafetyInfo(safetyInfo, user);
        return msg;
    }

    /**
     * 用户上传头像
     *
     * @param headerImgFile
     * @param userinfo
     * @return
     */
    @RequestMapping(value = "uploadHeaderImg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg uploadHeaderImg(@RequestParam("headerImgFile") MultipartFile[] headerImgFile, @ModelAttribute("userInfo") UserInfo userinfo) {
        Msg msg = null;
        msg = userService.uploadHeaderImg(headerImgFile, userinfo);
        return msg;

    }



    /**
     * 忘记密码
     *
     * @param username
     * @param session
     * @return
     */
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg forgetPassword(@RequestParam("username") String username, HttpSession session) {
        //如果用户名存在
        User user = null;
        user = userService.selectUserByUsername(username);
        if (user != null) {
            //发送手机短信验证码
            Msg msg = userService.sendMoblieVerificationCode(username);
            //通过username（手机号码）查询该user信息
            session.setAttribute("mobile_code", msg.getExtraData().get("mobile_code"));
            //把user信息放进session域中
            session.setAttribute("user_forget_pwd", user);
            return msg;
        }
        return new Msg(UserStateEnum.NONEXISTENSE);
    }

    /**
     * 忘记密码-修改密码(忽略旧密码)
     *
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/findpassword", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Msg findPassword(@RequestParam("password") String password, @RequestParam("code") String code,
                            HttpSession session) {
        //从session拿出用户信息
        User user = (User) session.getAttribute("user_forget_pwd");
        //从session域拿出手机短信验证码
        String forget_code = (String) session.getAttribute("mobile_code");
        //如果验证码不相等
        if (!code.equals(forget_code)) {
            return new Msg(UserStateEnum.NONVALIDATE);
        }
        //设置新的密码
        user.setPassword(Md5Utils.encode(password));
        //更新新的密码
        if (userMapper.updateByPrimaryKeySelective(user) > 0) {
            return new Msg(UserStateEnum.SUCCESSUPDATEPASSWORD);
        }
        return new Msg(UserStateEnum.FAILUPDATEPASSWORD);
    }


}