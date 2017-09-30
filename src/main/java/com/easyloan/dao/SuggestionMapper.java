package com.easyloan.dao;

import com.easyloan.bean.Suggestion;
import com.easyloan.bean.SuggestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuggestionMapper {
    int countByExample(SuggestionExample example);

    int deleteByExample(SuggestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    List<Suggestion> selectByExample(SuggestionExample example);

    Suggestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Suggestion record, @Param("example") SuggestionExample example);

    int updateByExample(@Param("record") Suggestion record, @Param("example") SuggestionExample example);

    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKey(Suggestion record);
}