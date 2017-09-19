package com.easyloan.dao;

import com.easyloan.bean.CompanyLoan;
import com.easyloan.bean.CompanyLoanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CompanyLoanMapper {
    long countByExample(CompanyLoanExample example);

    int deleteByExample(CompanyLoanExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyLoan record);

    int insertSelective(CompanyLoan record);

    List<CompanyLoan> selectByExample(CompanyLoanExample example);

    CompanyLoan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyLoan record, @Param("example") CompanyLoanExample example);

    int updateByExample(@Param("record") CompanyLoan record, @Param("example") CompanyLoanExample example);

    int updateByPrimaryKeySelective(CompanyLoan record);

    int updateByPrimaryKey(CompanyLoan record);
}