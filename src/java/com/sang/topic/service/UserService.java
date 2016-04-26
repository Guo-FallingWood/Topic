package com.sang.topic.service;

import com.sang.topic.mapper.UserMapper;
import com.sang.topic.model.User;
import com.sang.topic.util.MyBatisSession;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


/**
 * Created by arch on 2016/4/19.
 */
public class UserService {
	public User valid(String username, String password){
		try(SqlSession session = MyBatisSession.getSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

            List<User> list = userMapper.selectByUsernameAndPassword(user);
            if(list != null && !list.isEmpty())
                return list.get(0);
            else return null;
		}
	}

    public List<User> selectByPage(RowBounds rowBounds){
        try(SqlSession session = MyBatisSession.getSession()) {
            List<User> list = session.selectList("selectUserByPage", null, rowBounds);
            return list;
        }
    }

    public int selectCount(){
        try(SqlSession session = MyBatisSession.getSession()) {
            return session.getMapper(UserMapper.class).selectCount();
        }
    }

	public User get(int id){
		try(SqlSession session = MyBatisSession.getSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			return userMapper.selectByPrimaryKey(id);
		}
	}

	public int insert(User user){
		try(SqlSession session = MyBatisSession.getSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			int n;
			n = userMapper.insert(user);
			session.commit();
			return n;
		}
	}

	public int delete(int id) {
		try(SqlSession session = MyBatisSession.getSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			int n;
			n = userMapper.deleteByPrimaryKey(id);
			session.commit();
			return n;
		}
	}

	public int update(User user) {
		try(SqlSession session = MyBatisSession.getSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			int n;
			n = userMapper.updateByPrimaryKey(user);
			session.commit();
			return n;
		}
	}
}
