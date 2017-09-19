package com.easyloan.dao;

import com.easyloan.bean.JurisdictionDetails;
import com.easyloan.bean.JurisdictionDetailsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface JurisdictionDetailsMapper {
    long countByExample(JurisdictionDetailsExample example);

    int deleteByExample(JurisdictionDetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(JurisdictionDetails record);

    int insertSelective(JurisdictionDetails record);

    List<JurisdictionDetails> selectByExample(JurisdictionDetailsExample example);

    JurisdictionDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JurisdictionDetails record, @Param("example") JurisdictionDetailsExample example);

    int updateByExample(@Param("record") JurisdictionDetails record, @Param("example") JurisdictionDetailsExample example);

    int updateByPrimaryKeySelective(JurisdictionDetails record);

    int updateByPrimaryKey(JurisdictionDetails record);
}