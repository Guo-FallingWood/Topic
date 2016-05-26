package com.sang.topic.service;

import com.sang.topic.model.Role;
import com.sang.topic.service.RoleService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/5/8.
 */
public class RoleServiceTest {
    RoleService roleService;

    @Before
    public void setup(){
        roleService = new RoleService();
    }

    @Test
    public void getAll(){
        List<Role> list = roleService.getAll();
        System.out.println(list.size());
    }
}
