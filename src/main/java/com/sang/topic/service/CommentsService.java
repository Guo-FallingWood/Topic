package com.sang.topic.service;

import com.sang.topic.mapper.CommentsMapper;
import com.sang.topic.mapper.PostMapper;
import com.sang.topic.mapper.UserMapper;
import com.sang.topic.model.Comments;
import com.sang.topic.model.User;
import com.sang.topic.util.MyBatisSession;
import com.sang.topic.model.support.Page;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class CommentsService {

    public List<Comments> getCommentsByPostId(Integer postId) {
        try(SqlSession session = MyBatisSession.getSession()) {
            return session.getMapper(CommentsMapper.class).selectByPostId(postId);
        }
    }

    public List<Comments> getCommentsByPostIdAndPage(Integer postId, Page page){
        try(SqlSession session = MyBatisSession.getSession()) {
            int rowNumber = session.getMapper(CommentsMapper.class).selectCount();
            page.setRowNumber(rowNumber);
            return session.selectList("selectCommentsByPostIdAndPage", postId, page.toRowBounds());
        }
    }

    public int insert(Comments comments) {
        try(SqlSession session = MyBatisSession.getSession()) {
            User user = session.getMapper(UserMapper.class).selectByPrimaryKey(comments.getUserId());
            comments.setUserUsername(user.getUsername());
            comments.setCreateTime(new Date());
            int n = session.getMapper(CommentsMapper.class).insertSelective(comments);
            session.getMapper(PostMapper.class).updateCommentsNumberByPrimaryKey(comments.getPostId());
            session.commit();
            return n;
        }
    }

    public int update(Comments comments) {
        try (SqlSession session = MyBatisSession.getSession()) {
            int n = session.getMapper(CommentsMapper.class).updateByPrimaryKeySelective(comments);
            session.commit();
            return n;
        }
    }

}
