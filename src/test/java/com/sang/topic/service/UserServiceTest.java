package com.sang.topic.service;

import com.sang.topic.model.User;
import com.sang.topic.util.Page;
import com.sang.topic.util.Security;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/4/19.
 */
public class UserServiceTest {
    UserService userService;

    @Before
    public void before() {
        userService = new UserService();
    }

    @Test
    public void valid() {
        User user = userService.getByUsernameAndPassword("admin", Security.MD5("admin"));
        Assert.assertNotNull(user);
    }

    @Test
    public void getUserByPage() {
        Page page = new Page();
        page.setPageSize(2);
        page.setCurrentPage(3);
        List<User> list = userService.getByPage(page);
        System.out.print("username(0):" + list.get(0).getUsername() + " size:" + list.size());
        System.out.print(" pageNumber:" + page.getPageNumber());
        System.out.println();
    }

    @Test
    public void get() {
        User user = userService.get(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void getByUsername(){
        User user = userService.getByUsername("admin");
        Assert.assertNotNull(user);
    }

    @Ignore
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword(Security.MD5("111"));
        int n = userService.insert(user);
        Assert.assertEquals(n, 1);
    }

    @Test
    public void updateDiscard(){
        User user = new User();
        user.setId(1);
        user.setBan(1);
        int n = userService.update(user);
        Assert.assertEquals(n, 1);
        user.setBan(0);
        userService.update(user);
    }
}
