package com.easyloan.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyloan.bean.User;
import com.easyloan.bean.UserExample;
import com.easyloan.bean.UserExample.Criteria;
import com.easyloan.bean.UserInfo;
import com.easyloan.dao.UserInfoMapper;
import com.easyloan.dao.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 保存员工信息
     *
     * @param user
     */
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

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
     * 用户登录
     *
     * @param user
     * @return
     */
    public User login(User user) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        if (userMapper.selectByExample(example).size() > 0) {
            return userMapper.selectByExample(example).get(0);
        }
        return null;
    }

    /**
     * 保存用户信息
     *
     * @param userinfo
     * @param user
     * @return
     */
    public boolean saveInfo(UserInfo userinfo, User user) {
        if (userInfoMapper.insertSelective(userinfo) > 0) {
            user.setUserinfoId(userinfo.getId());
            if (userMapper.updateByPrimaryKey(user) > 0) {
                return true;
            }
        }
        return false;
    }

    public User selectUserWithInfoByKey(String id) {
        return userMapper.selectByPrimaryKeyWithInfo(id);
    }

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

    public boolean updateUserByKey(User user) {
        if (userMapper.updateByPrimaryKeySelective(user) > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateInfo(UserInfo userinfo) {
        if (userInfoMapper.updateByPrimaryKey(userinfo) > 0) {
            return true;
        }
        return false;
    }

    public UserInfo selectInfoByKey(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 发送手机短信验证码
     *
     * @param phone
     * @param request
     */
    public void sendMsg(String phone, HttpServletRequest request) {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("http://106.ihuyi.cn/webservice/sms.php?method=Submit");
        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");
        String mobile_code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println("手机验证码：" + mobile_code);
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        request.getSession().setAttribute("mobile_code", mobile_code);
        NameValuePair[] data = { // 提交短信
                new NameValuePair("account", "C39055568"),
                new NameValuePair("password", "d837c53d2afe695f31e47df64bf541b8"), // 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
                new NameValuePair("mobile", phone), new NameValuePair("content", content),};
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String SubmitResult = method.getResponseBodyAsString();
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
