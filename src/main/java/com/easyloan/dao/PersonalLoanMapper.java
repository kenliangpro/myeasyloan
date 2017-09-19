package com.easyloan.dao;

import com.easyloan.bean.PersonalLoan;
import com.easyloan.bean.PersonalLoanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PersonalLoanMapper {
    long countByExample(PersonalLoanExample example);

    int deleteByExample(PersonalLoanExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonalLoan record);

    int insertSelective(PersonalLoan record);

    List<PersonalLoan> selectByExample(PersonalLoanExample example);

    PersonalLoan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonalLoan record, @Param("example") PersonalLoanExample example);

    int updateByExample(@Param("record") PersonalLoan record, @Param("example") PersonalLoanExample example);

    int updateByPrimaryKeySelective(PersonalLoan record);

    int updateByPrimaryKey(PersonalLoan record);
}