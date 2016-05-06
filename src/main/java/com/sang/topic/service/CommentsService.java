package com.sang.topic.service;

import com.sang.topic.mapper.CommentsMapper;
import com.sang.topic.mapper.PostMapper;
import com.sang.topic.mapper.UserMapper;
import com.sang.topic.model.Comments;
import com.sang.topic.model.User;
import com.sang.topic.util.MyBatisSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by arch on 2016/5/1.
 */
public class CommentsService {

    public List<Comments> getCommentsByPostId(Integer postId) {
        try(SqlSession session = MyBatisSession.getSession()) {
            return session.getMapper(CommentsMapper.class).selectByPostId(postId);
        }
    }

    public int insert(Comments comments) {
        try(SqlSession session = MyBatisSession.getSession()) {
            User user = session.getMapper(UserMapper.class).selectByPrimaryKey(comments.getUserId());
            comments.setUserUsername(user.getUsername());
            int n = session.getMapper(CommentsMapper.class).insertSelective(comments);
            session.getMapper(PostMapper.class).updateCommentsNumberByPrimaryKey(comments.getPostId());
            session.commit();
            return n;
        }
    }
}
