package com.easyloan.dao;

import com.easyloan.bean.BorrowMoney;
import com.easyloan.bean.BorrowMoneyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BorrowMoneyMapper {
    long countByExample(BorrowMoneyExample example);

    int deleteByExample(BorrowMoneyExample example);

    int deleteByPrimaryKey(String id);

    int insert(BorrowMoney record);

    int insertSelective(BorrowMoney record);

    List<BorrowMoney> selectByExample(BorrowMoneyExample example);

    BorrowMoney selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BorrowMoney record, @Param("example") BorrowMoneyExample example);

    int updateByExample(@Param("record") BorrowMoney record, @Param("example") BorrowMoneyExample example);

    int updateByPrimaryKeySelective(BorrowMoney record);

    int updateByPrimaryKey(BorrowMoney record);
}