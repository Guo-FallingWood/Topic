package com.sang.topic.service;

import com.sang.topic.dao.RoleMapper;
import com.sang.topic.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAll(){
        return roleMapper.selectAll();
    }
}
