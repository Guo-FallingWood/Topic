package com.sang.topic.service;

import com.sang.topic.mapper.TopicMapper;
import com.sang.topic.util.MyBatisSession;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by arch on 2016/4/25.
 */
public class TopicService {
	SqlSession session = MyBatisSession.getSession();
	TopicMapper topicMapper = session.getMapper(TopicMapper.class);
}
