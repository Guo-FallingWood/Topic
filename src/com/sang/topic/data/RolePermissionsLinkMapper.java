package com.sang.topic.data;

import com.sang.topic.model.RolePermissionsLink;
import com.sang.topic.model.RolePermissionsLinkExample;
import java.util.List;

public interface RolePermissionsLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissionsLink record);

    int insertSelective(RolePermissionsLink record);

    List<RolePermissionsLink> selectByExample(RolePermissionsLinkExample example);

    RolePermissionsLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermissionsLink record);

    int updateByPrimaryKey(RolePermissionsLink record);
}