package com.easyloan.dao;

import com.easyloan.bean.SafetyQuestion;
import com.easyloan.bean.SafetyQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SafetyQuestionMapper {
    int countByExample(SafetyQuestionExample example);

    int deleteByExample(SafetyQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SafetyQuestion record);

    int insertSelective(SafetyQuestion record);

    List<SafetyQuestion> selectByExample(SafetyQuestionExample example);

    SafetyQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SafetyQuestion record, @Param("example") SafetyQuestionExample example);

    int updateByExample(@Param("record") SafetyQuestion record, @Param("example") SafetyQuestionExample example);

    int updateByPrimaryKeySelective(SafetyQuestion record);

    int updateByPrimaryKey(SafetyQuestion record);
}