package com.sang.topic.service;

import com.sang.topic.mapper.RoleMapper;
import com.sang.topic.model.Role;
import com.sang.topic.util.MyBatisSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleService {

    public List<Role> getAll(){
        try(SqlSession session = MyBatisSession.getSession()) {
            return session.getMapper(RoleMapper.class).selectAll();
        }
    }
}
