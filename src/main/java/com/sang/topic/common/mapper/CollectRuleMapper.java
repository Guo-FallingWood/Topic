package com.sang.topic.common.mapper;

import com.sang.topic.common.model.CollectRule;

import java.util.List;

public interface CollectRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectRule record);

    int insertSelective(CollectRule record);

    CollectRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectRule record);

    int updateByPrimaryKey(CollectRule record);

    List<CollectRule> selectAll();
}