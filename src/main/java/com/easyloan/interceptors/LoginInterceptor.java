package com.easyloan.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.easyloan.service.UserService;
import com.easyloan.utils.CookieUtils;
import com.google.gson.Gson;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;

	Gson gson = new Gson();

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 判断用户是否登录，如果有登录，则直接执行目标方法，否则，跳转到登录界面
		// 判断用户是否登录思路：用户登录成功，将用户的信息保存到cookie中，用户下次访问时，带着用户信息的cookie传到服务器，
		// 登录拦截器就需要获得此cookie信息，拿着cookie信息到数据库进行匹配

		// 从cookie中获得用户信息,用户信息是buyer对象对应的json数据
		String buyerInfoJson = CookieUtils.getCookieValue(request, CookieUtils.USER_TOKEN, "utf-8");
		boolean isLogin = false;
		if (buyerInfoJson != null) {
			isLogin = true;
		}
		if (!isLogin) {
			// 未登录状态
			// 获得用户要访问的路径，将用户要访问的路径追加到 /toLogin后面,比如说：用户要访问/buyer/closeBuy这个路径，
			// 将该路径追加到/toLogin后面，结果是 /toLogin?returnUrl=/buyer/closeBuy
			// 浏览器访问登录页面的路径是 /toLogin?returnUrl=/buyer/closeBuy
			String uri = request.getRequestURI();
			if (uri != null) {
//				request.getSession().setAttribute("returnUrl", uri);
			}
//			response.sendRedirect("/toLogin");
			return false;
		} else {
			// 已登录
			return true;
		}
	}

}
