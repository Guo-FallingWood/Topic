package com.sang.topic.service;

import com.sang.topic.common.entity.Comments;
import com.sang.topic.common.model.Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class CommentsServiceTest {
    @Autowired
    CommentsService commentsService;

    @Before
    public void setup(){
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
