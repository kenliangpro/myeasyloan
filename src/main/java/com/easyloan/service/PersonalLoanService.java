package com.easyloan.service;

import com.easyloan.bean.*;
import com.easyloan.dao.*;
import com.easyloan.dto.AverageCapital;
import com.easyloan.dto.Msg;
import com.easyloan.dto.PersonLoanDto;
import com.easyloan.dto.VocationalResult;
import com.easyloan.enums.UserStateEnum;
import com.easyloan.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PersonalLoanService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    PersonalLoanMapper personalLoanMapper;
    @Autowired
    PersonalLoanDatumMapper personalLoanDatumMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    SafetyQuestionMapper safetyQuestionMapper;


    /**
     * 上传贷款资料
     *
     * @param personLoanDto
     * @return
     */
    public Msg personalLoanExecution(PersonLoanDto personLoanDto, User user) {
        String mortgage_file_name = "";
        double loan_amount = personLoanDto.getLoan_amount();
        int loan_tern = personLoanDto.getLoan_tern();
        String address = personLoanDto.getAddress();
        String credit_card = personLoanDto.getCreditCard();
        String phone = personLoanDto.getPhone();

        PersonalLoanDatum personalLoanDatum = new PersonalLoanDatum();
        PersonalLoan personalLoan = new PersonalLoan();
        SafetyQuestion safetyQuestion = safetyQuestionMapper.selectByPrimaryKey(user.getSafetyQuestionId());

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(user.getUserinfoId());

        Map<String, Object> map = VocationalUtils.getVocationDetails(loan_amount, VocationalUtils.PERSONAL_LOAN_YEAR_RATE, loan_tern);

        if (personLoanDto.getLoanDatums() == null || personLoanDto.getLoanDatums().length == 0) {
            return new Msg(UserStateEnum.FILENULL);
        } else if (RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, phone)) {
            return new Msg(UserStateEnum.ERRORPHONENUMBER);
        }

        mortgage_file_name = FileUploadUtils.fileUpload(personLoanDto.getLoanDatums(), FileUploadUtils.LOAN_DATUM_PATH);

        if (mortgage_file_name == null) {
            return new Msg(UserStateEnum.FAILUPLOAD);
        }

        personalLoanDatum.setId(UUIDUtils.toPrimaryKey());
        personalLoanDatum.setIdentityFile(userInfo.getIdNumberImg());
        personalLoanDatum.setMortgageFile(mortgage_file_name);
        personalLoanDatum.setLoanDetails((String) map.get("vocational_details"));
        personalLoanDatum.setTotalInvest((Double) map.get("total_invest"));

        personalLoan.setId(UUIDUtils.toPrimaryKey());
        personalLoan.setLoanAmount(loan_amount);
        personalLoan.setLoanDeadline(FormatDate.calculateDeadLine(new Date(), loan_tern));
        personalLoan.setCreateTime(FormatDate.formatDate(new Date()));
        personalLoan.setAddr(address);
        personalLoan.setStatus(0);
        personalLoan.setDatumId(personalLoanDatum.getId());
        personalLoan.setUserId(user.getId());
        personalLoan.setLoanTern(loan_tern);
        personalLoan.setCreditCard(credit_card);
        personalLoan.setPhone(phone);

        if (personalLoanDatumMapper.insertSelective(personalLoanDatum) > 0) {
            if (personalLoanMapper.insertSelective(personalLoan) > 0) {
                return new Msg(UserStateEnum.COMMONSUCCESS);
            } else {
                return new Msg(UserStateEnum.UNKNOWNERROR);
            }
        } else {
            return new Msg(UserStateEnum.UNKNOWNERROR);
        }
    }


}
