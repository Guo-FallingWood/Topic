package com.sang.topic.data;

import com.sang.topic.model.Permissions;
import com.sang.topic.model.PermissionsExample;
import java.util.List;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    List<Permissions> selectByExample(PermissionsExample example);

    Permissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}