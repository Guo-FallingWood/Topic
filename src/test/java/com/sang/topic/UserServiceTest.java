package com.sang.topic;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import com.sang.topic.util.Page;
import org.junit.Assert;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/4/19.
 */
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	UserService userService;

    @Before
    public void before(){
        userService = new UserService();
    }

	@Test
	public void valid(){
		User user = userService.valid("admin", "admin");
        Assert.assertNotNull(user);
    }

	@Test
	public void getByPage(){
        Page page = new Page();
        page.setPageSize(2);
        page.setCurrentPage(3);
        List<User> list = userService.getByPage(page);
        System.out.print("username(0):"+list.get(0).getUsername()+" size:"+list.size());
        System.out.print(" pageNumber:"+page.getPageNumber());
        System.out.println();
    }

	@Test
	public void get(){
		User user = userService.get(39);
        Assert.assertNotNull(user);
    }

	@Test
	public void _insert(){
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("111");
		int n = userService.insert(user);
        Assert.assertEquals(n, 1);
    }

	@Test
	public void delete(){
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("111");

		User nUser = userService.valid(user.getUsername(), user.getPassword());
		int n =userService.delete(nUser.getId());
        Assert.assertEquals(n, 1);
	}
}
