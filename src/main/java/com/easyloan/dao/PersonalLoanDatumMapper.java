package com.easyloan.dao;

import com.easyloan.bean.PersonalLoanDatum;
import com.easyloan.bean.PersonalLoanDatumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalLoanDatumMapper {
    int countByExample(PersonalLoanDatumExample example);

    int deleteByExample(PersonalLoanDatumExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonalLoanDatum record);

    int insertSelective(PersonalLoanDatum record);

    List<PersonalLoanDatum> selectByExample(PersonalLoanDatumExample example);

    PersonalLoanDatum selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonalLoanDatum record, @Param("example") PersonalLoanDatumExample example);

    int updateByExample(@Param("record") PersonalLoanDatum record, @Param("example") PersonalLoanDatumExample example);

    int updateByPrimaryKeySelective(PersonalLoanDatum record);

    int updateByPrimaryKey(PersonalLoanDatum record);
}