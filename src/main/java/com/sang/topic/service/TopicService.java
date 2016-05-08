package com.sang.topic.service;

import com.sang.topic.mapper.TopicMapper;
import com.sang.topic.model.Topic;
import com.sang.topic.util.MyBatisSession;
import com.sun.javafx.scene.traversal.TopMostTraversalEngine;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by arch on 2016/4/25.
 */
public class TopicService {
    public List<Topic> getAll() {
        try(SqlSession session = MyBatisSession.getSession()){
            return session.getMapper(TopicMapper.class).selectAll();
        }
    }

    public Topic get(Integer id) {
        try(SqlSession session = MyBatisSession.getSession()){
            return session.getMapper(TopicMapper.class).selectByPrimaryKey(id);
        }
    }

    public int insert(Topic topic) {
        try(SqlSession session = MyBatisSession.getSession()){
            int n = session.getMapper(TopicMapper.class).insertSelective(topic);
            session.commit();
            return n;
        }
    }

    public int update(Topic topic) {
        try (SqlSession session = MyBatisSession.getSession()) {
            int n = session.getMapper(TopicMapper.class).updateByPrimaryKeySelective(topic);
            session.commit();
            return n;
        }
    }

}
