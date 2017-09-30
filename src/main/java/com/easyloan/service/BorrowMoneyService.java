package com.easyloan.service;

import com.easyloan.dao.BorrowDatumMapper;
import com.easyloan.dao.BorrowMoneyMapper;
import com.easyloan.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowMoneyService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BorrowMoneyMapper borrowMoneyMapper;
    @Autowired
    BorrowDatumMapper borrowDatumMapper;


}
