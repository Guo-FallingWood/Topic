package com.sang.topic.common.mapper;

import com.sang.topic.common.model.Post;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    int selectCount();

    int selectCountByTopic(Integer id);

    int updateCommentsNumberByPrimaryKey(Integer id);
}