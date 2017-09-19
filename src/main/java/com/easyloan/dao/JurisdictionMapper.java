package com.easyloan.dao;

import com.easyloan.bean.Jurisdiction;
import com.easyloan.bean.JurisdictionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface JurisdictionMapper {
    long countByExample(JurisdictionExample example);

    int deleteByExample(JurisdictionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    List<Jurisdiction> selectByExample(JurisdictionExample example);

    Jurisdiction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Jurisdiction record, @Param("example") JurisdictionExample example);

    int updateByExample(@Param("record") Jurisdiction record, @Param("example") JurisdictionExample example);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);
}