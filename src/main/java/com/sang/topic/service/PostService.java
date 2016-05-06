package com.sang.topic.service;

import com.sang.topic.mapper.CommentsMapper;
import com.sang.topic.mapper.PostMapper;
import com.sang.topic.mapper.UserMapper;
import com.sang.topic.model.Post;
import com.sang.topic.model.User;
import com.sang.topic.util.MyBatisSession;
import com.sang.topic.util.Page;
import javafx.geometry.Pos;
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

    public List<Post> getByTopicAndPage(Integer topicId, Page page) {
        try(SqlSession session = MyBatisSession.getSession()) {
            int rowNumber = session.getMapper(PostMapper.class).selectCountByTopic(topicId);
            page.setRowNumber(rowNumber);
            return session.selectList("selectPostByTopicAndPage", topicId, page.toRowBounds());
        }
    }

    public Post get(Integer id) {
        try(SqlSession session = MyBatisSession.getSession()) {
            return session.getMapper(PostMapper.class).selectByPrimaryKey(id);
        }
    }

    public int insert (Post post) {
        try(SqlSession session = MyBatisSession.getSession()) {
            User user = session.getMapper(UserMapper.class).selectByPrimaryKey(post.getUserId());
            post.setUserUsername(user.getUsername());
            int n = session.getMapper(PostMapper.class).insertSelective(post);
            session.commit();
            return n;
        }
    }
}
