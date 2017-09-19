package com.easyloan.dao;

import com.easyloan.bean.CompanyLoanDatum;
import com.easyloan.bean.CompanyLoanDatumExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CompanyLoanDatumMapper {
    long countByExample(CompanyLoanDatumExample example);

    int deleteByExample(CompanyLoanDatumExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyLoanDatum record);

    int insertSelective(CompanyLoanDatum record);

    List<CompanyLoanDatum> selectByExample(CompanyLoanDatumExample example);

    CompanyLoanDatum selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyLoanDatum record, @Param("example") CompanyLoanDatumExample example);

    int updateByExample(@Param("record") CompanyLoanDatum record, @Param("example") CompanyLoanDatumExample example);

    int updateByPrimaryKeySelective(CompanyLoanDatum record);

    int updateByPrimaryKey(CompanyLoanDatum record);
}