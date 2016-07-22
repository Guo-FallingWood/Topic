package com.sang.topic.service;

import com.sang.topic.mapper.CommentsMapper;
import com.sang.topic.mapper.PostMapper;
import com.sang.topic.mapper.UserMapper;
import com.sang.topic.model.Comments;
import com.sang.topic.model.User;
import com.sang.topic.util.MyBatisSession;
import com.sang.topic.model.support.Page;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostMapper postMapper;

    public List<Comments> getCommentsByPostId(Integer postId) {
        return commentsMapper.selectByPostId(postId);
    }

    public List<Comments> getCommentsByPostIdAndPage(Integer postId, Page page) {
        try (SqlSession session = MyBatisSession.getSession()) {
            int rowNumber = session.getMapper(CommentsMapper.class).selectCount();
            page.setRowNumber(rowNumber);
            return session.selectList("selectCommentsByPostIdAndPage", postId, page.toRowBounds());
        }
    }

    @Transactional
    public int insert(Comments comments) {
        User user = userMapper.selectByPrimaryKey(comments.getUserId());
        comments.setUserUsername(user.getUsername());
        comments.setCreateTime(new Date());
        int n = commentsMapper.insertSelective(comments);
        postMapper.updateCommentsNumberByPrimaryKey(comments.getPostId());
        return n;
    }

    @Transactional
    public int update(Comments comments) {
        return commentsMapper.updateByPrimaryKeySelective(comments);
    }

}
