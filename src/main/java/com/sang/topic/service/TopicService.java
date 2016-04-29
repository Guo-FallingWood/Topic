package com.sang.topic.service;

import com.sang.topic.mapper.TopicMapper;
import com.sang.topic.model.Topic;
import com.sang.topic.util.MyBatisSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by arch on 2016/4/25.
 */
public class TopicService {
    public List<Topic> getAll(){
        try(SqlSession session = MyBatisSession.getSession()){
            return session.getMapper(TopicMapper.class).selectAll();
        }
    }
}
