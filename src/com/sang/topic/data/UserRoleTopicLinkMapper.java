package com.sang.topic.data;

import com.sang.topic.model.UserRoleTopicLink;
import com.sang.topic.model.UserRoleTopicLinkExample;
import java.util.List;

public interface UserRoleTopicLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleTopicLink record);

    int insertSelective(UserRoleTopicLink record);

    List<UserRoleTopicLink> selectByExample(UserRoleTopicLinkExample example);

    UserRoleTopicLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleTopicLink record);

    int updateByPrimaryKey(UserRoleTopicLink record);
}