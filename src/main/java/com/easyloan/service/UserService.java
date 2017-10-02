package com.easyloan.service;

import com.easyloan.bean.SafetyQuestion;
import com.easyloan.bean.User;
import com.easyloan.bean.UserExample;
import com.easyloan.bean.UserExample.Criteria;
import com.easyloan.bean.UserInfo;
import com.easyloan.dao.SafetyQuestionMapper;
import com.easyloan.dao.UserInfoMapper;
import com.easyloan.dao.UserMapper;
import com.easyloan.dto.Msg;
import com.easyloan.dto.UserDto;
import com.easyloan.dto.UserResult;
import com.easyloan.enums.UserStateEnum;
import com.easyloan.utils.*;
import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    SafetyQuestionMapper safetyQuestionMapper;


    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    public boolean isExist(String username) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        if (userMapper.selectByExample(example).size() > 0) {
            return true;
        }
        return false;
    }


    /**
     * 注册第一次，输入账号，密码，验证码
     *
     * @param userDto
     * @return
     */
    public UserResult first_step_register(UserDto userDto) {
        if (!userDto.getVerification_code().equals(userDto.getSession_verification_code())) {
            return new UserResult(UserStateEnum.NONVALIDATE);
        } else if (isExist(userDto.getUsername())) {
            return new UserResult(UserStateEnum.EXSTIENS);
        }
        return new UserResult(UserStateEnum.NEXTSTEP);
    }

    /**
     * 注册的第二步，即完善个人信息
     *
     * @param userDto
     * @param userInfo
     * @return
     */
    public UserResult second_step_register(UserDto userDto, UserInfo userInfo, MultipartFile[] headerImgFile) {

        String header_img_name = "";

        //如果文件为空
        if (headerImgFile.length == 0) {
            return new UserResult(UserStateEnum.FILENULL);
        } else if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_EMAIL, userInfo.getEmail())) {
            return new UserResult(UserStateEnum.ERROREMAIL);
        } else if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, userInfo.getPhone())) {
            return new UserResult(UserStateEnum.ERRORPHONENUMBER);
        }


        header_img_name = FileUploadUtils.fileUpload(headerImgFile, FileUploadUtils.HEAD_IMG_PATH);
        if (header_img_name == null) {
            return new UserResult(UserStateEnum.FAILUPLOAD);
        }

        userInfo.setId(UUIDUtils.toPrimaryKey());
        userInfo.setPhone(userDto.getUsername());
        userInfo.setHeaderImg(header_img_name);

        User user = new User();
        user.setId(UUIDUtils.toPrimaryKey());
        user.setUsername(userDto.getUsername());
        user.setPassword(Md5Utils.encode(userDto.getPassword()));
        user.setRegisterTime(FormatDate.formatDate(new Date()));
        //是否删除
        user.setIsDel(0);
        //是否被屏蔽
        user.setIsShield(0);

        if (saveUser(userInfo, user)) {
            return new UserResult(UserStateEnum.SIGNUP);
        }

        return new UserResult(UserStateEnum.UNKNOWNERROR);

    }

    /**
     * 用户登录
     *
     * @param userDto
     * @return
     */
    public UserResult userLogin(UserDto userDto) {
        User user = new User();
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();

        //手机号码验证
        if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, userDto.getUsername())) {
            return new UserResult(UserStateEnum.ILLEGAL);
            //验证码验证
        } else if (!userDto.getVerification_code().equals(userDto.getSession_verification_code())) {
            return new UserResult(UserStateEnum.NONVALIDATE);

        }

        criteria.andUsernameEqualTo(userDto.getUsername());
        criteria.andPasswordEqualTo(Md5Utils.getMD5Pwd(userDto.getPassword()));

        if (userMapper.selectByExample(example).size() > 0) {
            user = userMapper.selectByExample(example).get(0);
            return new UserResult(UserStateEnum.LOGIN, user);
        } else {
            return new UserResult(UserStateEnum.MISPASSWORDORUSERNAME);
        }
    }


    /**
     * 保存用户信息
     *
     * @param userinfo
     * @param user
     * @return
     */
    public boolean saveUser(UserInfo userinfo, User user) {
        if (userInfoMapper.insertSelective(userinfo) > 0) {
            user.setUserinfoId(userinfo.getId());
            if (userMapper.insertSelective(user) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 保存用户安全信息
     *
     * @param user
     * @param safetyInfo
     * @return
     */
    public boolean saveSafetyInfo(User user, SafetyQuestion safetyInfo) {

        safetyInfo.setSafetyLevel(setSafetyLevel(safetyInfo));
        if (safetyQuestionMapper.insertSelective(safetyInfo) > 0) {
            user.setSafetyQuestionId(safetyInfo.getId());
            if (userMapper.updateByPrimaryKey(user) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 用户认证
     *
     * @param idNumber
     * @param idNumberImgs
     * @return
     */
    public Msg userCertification(String idNumber, MultipartFile[] idNumberImgs, String realName, UserInfo userInfo) {
        String img_names = "";
        if (idNumberImgs == null || idNumberImgs.length == 0) {
            return new Msg(UserStateEnum.FILENULL);
        }

        if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_CHINESE, realName)) {
            return new Msg(UserStateEnum.ERRORREALNAME);
        }

        if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_ID_CARD, idNumber)) {
            return new Msg(UserStateEnum.ERRORIDNUMBER);
        }

        img_names = FileUploadUtils.fileUpload(idNumberImgs, FileUploadUtils.ID_NUMBER_IMG_PATH);
        if (img_names == null) {
            return new Msg(UserStateEnum.FAILUPLOAD);
        }

        // 已经创建了userinfo，即user中的userinfo_id不为空
        if (userInfo.getId() != null) {
            userInfo.setIdNumberImg(img_names.substring(0, img_names.length() - 1));
            userInfo.setIdNumber(idNumber);
            userInfo.setRealName(realName);
            //0代表还没审核
            userInfo.setStatus(0);
            userInfoMapper.updateByPrimaryKey(userInfo);
            return new Msg(UserStateEnum.COMMONSUCCESS);
        }
        return new Msg(UserStateEnum.UNKNOWNERROR);
    }

    /**
     * 用户更改头像
     *
     * @param headerImgFile
     * @param userinfo
     * @return
     */
    public Msg updateHeaderImg(MultipartFile[] headerImgFile, UserInfo userinfo) {
        if (headerImgFile.length == 0 || headerImgFile == null) {
            return new Msg(UserStateEnum.FILENULL);
        }
        String header_img = FileUploadUtils.fileUpload(headerImgFile, FileUploadUtils.HEAD_IMG_PATH);
        if (header_img != null) {
            userinfo.setHeaderImg(header_img);
            userInfoMapper.updateByPrimaryKey(userinfo);
            return Msg.success().addExtraData("header_img", header_img);
        }
        return new Msg(UserStateEnum.FAILUPLOAD);
    }

    /**
     * 更新用户信息
     *
     * @param userinfo
     * @return
     */
    public Msg updateUserInfo(UserInfo userinfo) {
        if (userinfo != null) {
            if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_EMAIL, userinfo.getEmail())) {
                return new Msg(UserStateEnum.ERROREMAIL);
            } else if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, userinfo.getPhone())) {
                return new Msg(UserStateEnum.ERRORPHONENUMBER);
            }

            if (userInfoMapper.updateByPrimaryKey(userinfo) > 0) {
                return Msg.success();
            }
        }
        return new Msg(UserStateEnum.UPDATEUSERINFOERROR);
    }


    /**
     * 完善安全用户信息
     *
     * @param safetyInfo
     * @param user
     * @return
     */
    public Msg perfectSafetyInfo(SafetyQuestion safetyInfo, User user) {

        //如果安全信息已经设置，进行更新操作
        if (user != null) {
            if (user.getSafetyQuestionId() != null) {
                if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_EMAIL, safetyInfo.getSafetyEmail())) {
                    return new Msg(UserStateEnum.ERROREMAIL);
                }
                safetyInfo.setSafetyLevel(setSafetyLevel(safetyInfo));
                if (safetyQuestionMapper.updateByPrimaryKeySelective(safetyInfo) > 0) {
                    return Msg.success();
                }
            } else {
                //如果安全信息未设置,进行插入操作
                safetyInfo.setId(UUIDUtils.toPrimaryKey());
                if (saveSafetyInfo(user, safetyInfo)) {
                    return Msg.success();
                }
            }
        }
        return new Msg(UserStateEnum.UPDATEUSERINFOERROR);
    }

    /**
     * 设置用户安全等级
     *
     * @param safetyInfo
     */
    public int setSafetyLevel(SafetyQuestion safetyInfo) {
        int safety_level = 0;
        if ((!"".equals(safetyInfo.getAnswer()) && !"".equals(safetyInfo.getQuestion())) || !"".equals(safetyInfo.getSafetyEmail())) {
            safety_level = 1;
            if (!"".equals(safetyInfo.getAnswer()) && !"".equals(safetyInfo.getQuestion()) && !"".equals(safetyInfo.getSafetyEmail())) {
                safety_level = 2;
            }
        }
        return safety_level;
    }


    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User selectUserByUsername(String username) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> user = userMapper.selectByExample(example);
        if (user.size() > 0) {
            return user.get(0);
        }
        return null;
    }


    /**
     * 发送手机短信验证码
     *
     * @param phone
     */
    public Msg sendMoblieVerificationCode(String phone) {

        //验证是不是手机
        if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, phone)) {
            return new Msg(UserStateEnum.ILLEGAL);
        }

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("http://106.ihuyi.cn/webservice/sms.php?method=Submit");
        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");
        String mobile_code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println("手机验证码：" + mobile_code);
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        NameValuePair[] data = { // 提交短信
                new NameValuePair("account", "C39055568"),
                new NameValuePair("password", "d837c53d2afe695f31e47df64bf541b8"), // 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
                new NameValuePair("mobile", phone), new NameValuePair("content", content),};
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            return Msg.success().addExtraData("mobile_code", mobile_code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.fail();
    }

    /**
     * 检查是否进行实名认证
     *
     * @param user
     * @return
     */
    public Msg checkIsCertification(User user) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(user.getUserinfoId());
        //如果未进行实名认证
        if (userInfo.getStatus() == 0) {
            return new Msg(UserStateEnum.UNCERTIFICATION);
        } else {
            return new Msg(UserStateEnum.CERTIFICATION);
        }
    }


}