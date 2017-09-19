package com.easyloan.dao;

import com.easyloan.bean.BorrowDatum;
import com.easyloan.bean.BorrowDatumExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BorrowDatumMapper {
    long countByExample(BorrowDatumExample example);

    int deleteByExample(BorrowDatumExample example);

    int deleteByPrimaryKey(String id);

    int insert(BorrowDatum record);

    int insertSelective(BorrowDatum record);

    List<BorrowDatum> selectByExample(BorrowDatumExample example);

    BorrowDatum selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BorrowDatum record, @Param("example") BorrowDatumExample example);

    int updateByExample(@Param("record") BorrowDatum record, @Param("example") BorrowDatumExample example);

    int updateByPrimaryKeySelective(BorrowDatum record);

    int updateByPrimaryKey(BorrowDatum record);
}