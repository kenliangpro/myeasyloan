package com.easyloan.controller;

import com.easyloan.bean.User;
import com.easyloan.dao.UserInfoMapper;
import com.easyloan.dto.Msg;
import com.easyloan.dto.PersonLoanDto;

import com.easyloan.service.PersonalLoanService;
import com.easyloan.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/personalLoan")
public class PersonalLoanController {

    @Autowired
    PersonalLoanService personalLoanService;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 跳转到个人贷款页面
     *
     * @return
     */
    @RequestMapping("/toPersonalLoanPage")
    public String toPersonalLoanPage(HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user != null) {
            return "personalloan";
        } else {
            return "redirect:/testPage";
        }

    }

    @RequestMapping("/toNextStep")
    public String toNextStep() {
        return "nextstep";

    }


    @RequestMapping(value = "/personalLoanExecution")
    @ResponseBody
    public Msg personalLoanExecution(PersonLoanDto personLoanDto, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        Double principal = (Double) session.getAttribute("principal");
        int totalMonth = (Integer) session.getAttribute("totalMonth");
        personLoanDto.setLoan_tern(totalMonth);
        personLoanDto.setLoan_amount(principal);
        return personalLoanService.personalLoanExecution(personLoanDto, user);
    }


}
