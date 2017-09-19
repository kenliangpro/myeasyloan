package com.easyloan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToHtmlController {
	
	@RequestMapping("/testPage")
	public String toReg(){
		return "test";
	}
}
