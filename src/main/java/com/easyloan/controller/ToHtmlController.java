package com.easyloan.controller;

import com.easyloan.bean.User;
import com.easyloan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToHtmlController {

	@Autowired
	UserService userService;

	@RequestMapping("/testPage")
	public String toReg(){
		return "test";
	}

	@RequestMapping("/setSafetyInfo")
	public String toSetSafetyInfo() {

		return "safetyInfo";
	}

	@RequestMapping("/setCertification")
	public String touserCertification() {

		return "userCertification";
	}



	@RequestMapping(value = "/index")
	public String test(){
		return "frontend/index";
	}






}
