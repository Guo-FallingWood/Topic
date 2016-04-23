package com.sang.topic.service;

import com.sang.topic.MyBatisSession;
import com.sang.topic.data.UserMapper;
import com.sang.topic.model.User;
import com.sang.topic.model.UserExample;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by arch on 2016/4/19.
 */
public class UserService {
	SqlSession session = MyBatisSession.getSession();
	UserMapper userMapper = session.getMapper(UserMapper.class);

	public boolean valid(User user){
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> result = userMapper.selectByExample(userExample);
		return !result.isEmpty();
	}

	public List<User> getAll(){
		return userMapper.selectByExample(new UserExample());
	}

	public User get(int id){
		return userMapper.selectByPrimaryKey(id);
	}

	public int insert(User user){
		int n = userMapper.insert(user);
		session.commit();
		return n;
	}

	public int delete(int id) {
		int n = userMapper.deleteByPrimaryKey(id);
		session.commit();
		return n;
	}

	public int update(User user) {
		int n = userMapper.updateByPrimaryKey(user);
		session.commit();
		return n;
	}
}
