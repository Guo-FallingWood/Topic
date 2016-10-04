package com.sang.topic.common.mapper;

import com.sang.topic.common.model.CollectUrl;

import java.util.List;

public interface CollectUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectUrl record);

    int insertSelective(CollectUrl record);

    CollectUrl selectByPrimaryKey(Integer id);

    List<CollectUrl> selectAll();

    int updateByPrimaryKeySelective(CollectUrl record);

    int updateByPrimaryKey(CollectUrl record);
}