package com.sang.topic.service;

import com.sang.topic.mapper.UserMapper;
import com.sang.topic.model.User;
import com.sang.topic.util.MyBatisSession;
import com.sang.topic.model.support.Page;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getByUsernameAndPassword(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> list = userMapper.selectByUsernameAndPassword(user);
        if (list != null && !list.isEmpty())
            return list.get(0);
        else return null;
    }

    public List<User> getByPage(Page page) {
        try (SqlSession session = MyBatisSession.getSession()) {
            int rowNumber = session.getMapper(UserMapper.class).selectCount();
            page.setRowNumber(rowNumber);
            List<User> list = session.selectList("selectUserByPage", null, page.toRowBounds());
            return list;
        }
    }

    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User getByUsername(String username) {
        List<User> list = userMapper.selectByUsername(username);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    @Transactional
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    @Transactional
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
