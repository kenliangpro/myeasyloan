package com.easyloan.controller;

import com.easyloan.bean.User;
import com.easyloan.dto.Msg;
import com.easyloan.dto.PersonLoanDto;
import com.easyloan.dto.VocationalResult;
import com.easyloan.enums.UserStateEnum;
import com.easyloan.service.BorrowMoneyService;
import com.easyloan.service.PersonalLoanService;
import com.easyloan.service.UserService;
import com.easyloan.utils.VocationalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class VocationalController {

    @Autowired
    PersonalLoanService personalLoanService;
    @Autowired
    BorrowMoneyService borrowMoneyService;
    @Autowired
    UserService userService;

    /**
     * 检查是否实名认证
     *
     * @param session
     * @param principal
     * @param totalMonth
     * @return
     */
    @RequestMapping(value = "/vocational/checkIsCertification")
    @ResponseBody
    public Msg checkIsCertification(HttpSession session,
                                    @RequestParam("principal") double principal,
                                    @RequestParam("totalMonth") int totalMonth) {
        Msg msg = null;
        User user = (User) session.getAttribute("session_user");
        msg = userService.checkIsCertification(user);
        //已实名认证
        if (msg.getStateEnum().equals(UserStateEnum.CERTIFICATION)) {
            session.setAttribute("principal",principal);
            session.setAttribute("totalMonth",totalMonth);
        }
        return msg;
    }

    /**
     * 查看业务计划(个人贷款)
     *
     * @param principal
     * @param totalMonth
     * @return
     */
    @RequestMapping(value = "/personalLoan/checkPlan")
    @ResponseBody
    public VocationalResult personalLoanPlan(@RequestParam("principal") double principal,
                                             @RequestParam("totalMonth") int totalMonth) {
        return VocationalUtils.generateLoanPlan(principal, VocationalUtils.PERSONAL_LOAN_YEAR_RATE, totalMonth);
    }

    /**
     * 查看业务计划(公司贷款)
     *
     * @param principal
     * @param totalMonth
     * @return
     */
    @RequestMapping(value = "/companyLoan/checkPlan")
    @ResponseBody
    public VocationalResult companyLoanPlan(@RequestParam("principal") double principal,
                                            @RequestParam("totalMonth") int totalMonth) {
        return VocationalUtils.generateLoanPlan(principal, VocationalUtils.COMPANY_LOAN_YEAR_RATE, totalMonth);
    }

    /**
     * 查看业务计划(个人借钱)
     *
     * @param principal
     * @param totalMonth
     * @return
     */
    @RequestMapping(value = "/personBorrow/checkPlan")
    @ResponseBody
    public VocationalResult personalBorrowPlan(@RequestParam("principal") double principal,
                                               @RequestParam("totalMonth") int totalMonth) {
        return VocationalUtils.generateLoanPlan(principal, VocationalUtils.PERSONAL_BORROW_MONEY, totalMonth);
    }


}
