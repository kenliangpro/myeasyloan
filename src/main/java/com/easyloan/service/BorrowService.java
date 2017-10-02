package com.easyloan.service;

import com.easyloan.bean.BorrowDatum;
import com.easyloan.bean.BorrowMoney;
import com.easyloan.bean.User;
import com.easyloan.dao.BorrowDatumMapper;
import com.easyloan.dao.BorrowMoneyMapper;
import com.easyloan.dao.UserInfoMapper;
import com.easyloan.dao.UserMapper;
import com.easyloan.dto.Msg;
import com.easyloan.enums.UserStateEnum;
import com.easyloan.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

@Service
public class BorrowService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BorrowMoneyMapper borrowMoneyMapper;
    @Autowired
    BorrowDatumMapper borrowDatumMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 个人借钱
     *
     * @param user
     * @param borrowMoney
     * @param borrow_file
     * @return
     */
    public Msg borrowExecution(User user, BorrowMoney borrowMoney, MultipartFile[] borrow_file) {
        BorrowDatum borrowDatum = new BorrowDatum();
        String mortgage_file_name = "";
        Map<String, Object> map = VocationalUtils.getVocationDetails(borrowMoney.getBorrowAmount(), VocationalUtils.PERSONAL_BORROW_MONEY, borrowMoney.getBorrowTern());

        if (borrow_file == null || borrow_file.length == 0) {
            return new Msg(UserStateEnum.FILENULL);
        } else if (!RegxDictionary.validateRegx(RegxDictionary.REGEX_MOBILE, borrowMoney.getPhone())) {
            return new Msg(UserStateEnum.ERRORPHONENUMBER);
        }

        mortgage_file_name = FileUploadUtils.fileUpload(borrow_file, FileUploadUtils.BORROW_DATUM_PATH);
        if (mortgage_file_name == null) {
            return new Msg(UserStateEnum.FAILUPLOAD);
        }

        borrowDatum.setId(UUIDUtils.toPrimaryKey());
        borrowDatum.setIdentityFile(userInfoMapper.selectByPrimaryKey(user.getUserinfoId()).getIdNumberImg());
        borrowDatum.setBorrowDetails((String) map.get("vocational_details"));
        borrowDatum.setTotalInvest((Double) map.get("total_invest"));
        borrowDatum.setBorrowFile(mortgage_file_name);

        borrowMoney.setId(UUIDUtils.toPrimaryKey());
        borrowMoney.setStatus(0);
        borrowMoney.setUserId(user.getId());
        borrowMoney.setCreateTime(FormatDate.formatDate(new Date()));
        borrowMoney.setBorrowDeadline(FormatDate.calculateDeadLine(new Date(), borrowMoney.getBorrowTern()));
        borrowMoney.setBorrowDatumId(borrowDatum.getId());

        if (borrowDatumMapper.insertSelective(borrowDatum) > 0) {
            if (borrowMoneyMapper.insertSelective(borrowMoney) > 0) {
                return new Msg(UserStateEnum.COMMONSUCCESS);
            } else {
                return new Msg(UserStateEnum.UNKNOWNERROR);
            }
        } else {
            return new Msg(UserStateEnum.UNKNOWNERROR);
        }


    }
}
