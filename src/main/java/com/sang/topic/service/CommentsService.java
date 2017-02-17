package com.sang.topic.service;

import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.model.ValidationResponse;
import com.sang.topic.dao.CommentsMapper;
import com.sang.topic.dao.PostMapper;
import com.sang.topic.dao.UserMapper;
import com.sang.topic.common.entity.Comments;
import com.sang.topic.common.entity.User;
import com.sang.topic.util.MyBatisSession;
import com.sang.topic.common.model.Page;
import com.sang.topic.util.ResponseUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

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

    /**
     * 发表评论
     * @param comments
     * @return
     */
    @Transactional
    public ValidationResponse create(Comments comments) {
        comments.setContent(HtmlUtils.htmlEscape(comments.getContent()));
        int n = insert(comments);
        if (n > 0)
            return ResponseUtil.successValidation(MessageConstants.POST_CREATE_SUCCESS);
        return ResponseUtil.successValidation(MessageConstants.POST_CREATE_FAIL);
    }
}
