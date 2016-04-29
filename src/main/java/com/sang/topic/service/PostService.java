package com.sang.topic.service;

import com.sang.topic.mapper.PostMapper;
import com.sang.topic.model.Post;
import com.sang.topic.util.MyBatisSession;
import com.sang.topic.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by arch on 2016/4/29.
 */
public class PostService {
    public List<Post> getByPage(Page page){
        try(SqlSession session = MyBatisSession.getSession()) {
            int rowNumber = session.getMapper(PostMapper.class).selectCount();
            page.setRowNumber(rowNumber);
            return session.selectList("selectPostByPage", null, page.toRowBounds());
        }
    }

    public List<Post> getByTopicAndPage(Integer topicId, Page page){
        try(SqlSession session = MyBatisSession.getSession()) {
            int rowNumber = session.getMapper(PostMapper.class).selectCountByTopic(topicId);
            page.setRowNumber(rowNumber);
            return session.selectList("selectPostByTopicAndPage", topicId, page.toRowBounds());
        }
    }
}
