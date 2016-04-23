package test;

import com.sang.topic.MyBatisSession;
import com.sang.topic.data.UserMapper;
import com.sang.topic.data.UserMapper;
import com.sang.topic.model.User;
import com.sang.topic.model.UserExample;
import com.sang.topic.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/4/19.
 */
public class UserTest {

	UserService userService = new UserService();

	@Test
	public void UserSelectAll(){
		List<User> list = userService.getAll();
		System.out.println(list.size());
	}

	@Test
	public void UserValid(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		boolean result = userService.valid(user);
		System.out.println(result);
	}

}
