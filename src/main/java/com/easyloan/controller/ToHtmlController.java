package com.easyloan.controller;

import com.easyloan.bean.User;
import com.easyloan.bean.UserExample;
import com.easyloan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/register1")
	public String register1(){
		return "register1";
	}

	@RequestMapping("/register2")
	public String register2(){
		return "register2";
	}




	@RequestMapping(value = "/index")
	public String test(){
		return "frontend/index";
	}






}
