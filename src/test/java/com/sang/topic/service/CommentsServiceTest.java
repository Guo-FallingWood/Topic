package com.sang.topic.service;

import com.sang.topic.model.Comments;
import com.sang.topic.model.support.Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class CommentsServiceTest {
    CommentsService commentsService;

    @Before
    public void setup(){
        commentsService = new CommentsService();
    }

    @Test
    public void getCommentsByPostId() {
        List<Comments> list = commentsService.getCommentsByPostId(1);
        System.out.println(list.size());
    }

    @Test
    public void getCommentsByPostIdAndPage() {
        Page page = new Page();
        List<Comments> list = commentsService.getCommentsByPostIdAndPage(64, page);
        System.out.println(list.size());
    }

    @Ignore
    @Test
    public void insertComments() {
        Comments comments = new Comments();
        comments.setContent("测试回复");
        comments.setPostId(1);
        comments.setUserId(39);
        int n = commentsService.insert(comments);
        Assert.assertEquals(n, 1);
    }
}
