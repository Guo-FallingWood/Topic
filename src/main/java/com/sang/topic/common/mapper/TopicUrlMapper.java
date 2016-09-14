package com.sang.topic.common.mapper;

import com.sang.topic.common.model.TopicUrl;

import java.util.List;

public interface TopicUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicUrl record);

    int insertSelective(TopicUrl record);

    TopicUrl selectByPrimaryKey(Integer id);

    List<TopicUrl> selectAll();

    int updateByPrimaryKeySelective(TopicUrl record);

    int updateByPrimaryKey(TopicUrl record);
}