package com.sang.topic.mapper;

import com.sang.topic.model.Post;
import com.sang.topic.model.Topic;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    int selectCount();

    int selectCountByTopic(Integer id);
}