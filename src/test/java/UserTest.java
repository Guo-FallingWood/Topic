package test.java;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import com.sang.topic.util.Page;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/4/19.
 */
public class UserTest {

	UserService userService = new UserService();

	@Test
	public void valid(){
		User user = userService.valid("admin", "admin");
		System.out.println(user.getUsername());
	}

	@Test
	public void getByPage(){
        int rowNumber = userService.selectCount();
        Page page = new Page(rowNumber, "");
        page.setPageSize(2);
        page.setCurrentPage(3);
        List<User> list = userService.selectByPage(page.toRowBounds());
        System.out.print("username(0):"+list.get(0).getUsername()+" size:"+list.size());
        System.out.print(" pageNumber:"+page.getPageNumber());
        System.out.println();
    }

	@Test
	public void get(){
		User user = userService.get(1);
		System.out.println(user.getUsername());
	}

	@Test
	public void insert(){
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("111");
		System.out.println(userService.insert(user));
        User user1 = userService.valid(user.getUsername(), user.getPassword());
        System.out.println(user1.getId());
    }

	@Test
	public void delete(){
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("111");

		User nUser = userService.valid(user.getUsername(), user.getPassword());
		System.out.println(userService.delete(nUser.getId()));
	}
}
