package com.easyloan.service;

import com.easyloan.bean.*;
import com.easyloan.dao.*;
import com.easyloan.dto.Msg;
import com.easyloan.enums.UserStateEnum;
import com.easyloan.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    /**
     * 执行个人贷款操作
     *
     * @param personalLoan
     * @param user
     * @return
     */
    public Msg personalLoanExecution(PersonalLoan personalLoan, User user,MultipartFile[] mortgage_file) {
        String mortgage_file_name = "";
//        double loan_amount = personLoanDto.getLoan_amount();
//        int loan_tern = personLoanDto.getLoan_tern();
//        String address = personLoanDto.getAddress();
//        String credit_card = personLoanDto.getCreditCard();
//        String phone = personLoanDto.getPhone();

        PersonalLoanDatum personalLoanDatum = new PersonalLoanDatum();

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(user.getUserinfoId());

        Map<String, Object> map = VocationalUtils.getVocationDetails(personalLoan.getLoanAmount(), VocationalUtils.PERSONAL_LOAN_YEAR_RATE, personalLoan.getLoanTern());

        if (mortgage_file == null || mortgage_file.length == 0) {
            return new Msg(UserStateEnum.FILENULL);
        } else if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, personalLoan.getPhone())) {
            return new Msg(UserStateEnum.ERRORPHONENUMBER);
        }

        mortgage_file_name = FileUploadUtils.fileUpload(mortgage_file, FileUploadUtils.PERSONAL_DATUM_PATH);

        if (mortgage_file_name == null) {
            return new Msg(UserStateEnum.FAILUPLOAD);
        }

        personalLoanDatum.setId(UUIDUtils.toPrimaryKey());
        personalLoanDatum.setIdentityFile(userInfo.getIdNumberImg());
        personalLoanDatum.setMortgageFile(mortgage_file_name);
        personalLoanDatum.setLoanDetails((String) map.get("vocational_details"));
        personalLoanDatum.setTotalInvest((Double) map.get("total_invest"));

        personalLoan.setId(UUIDUtils.toPrimaryKey());
        personalLoan.setLoanDeadline(FormatDate.calculateDeadLine(new Date(), personalLoan.getLoanTern()));
        personalLoan.setCreateTime(FormatDate.formatDate(new Date()));
        personalLoan.setStatus(0);
        personalLoan.setDatumId(personalLoanDatum.getId());
        personalLoan.setUserId(user.getId());

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
