package com.sang.topic.service;

import com.sang.topic.common.entity.Post;
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
public class PostServiceTest {
    @Autowired
    PostService postService;

    @Before
    public void setup(){
    }

    @Test
    public void getByPage(){
        Page page = new Page();
        page.setPageSize(2);
        page.setCurrentPage(3);
        List<Post> list = postService.getByPage(page);
        System.out.println(list.size());
    }

    @Test
    public void getByTopicAndPage(){
        Page page = new Page();
        page.setCurrentPage(2);
        page.setPageSize(100);
        List<Post> list = postService.getByTopicAndPage(1, page);
        for (Post post : list) {
            System.out.println(post.getLastTime());
        }
    }

    @Ignore
    @Test
    public void insert(){
        Post post = new Post();
        post.setContent("测试文章");
        post.setTitle("测试标题");
        post.setTopicId(1);
        post.setUserId(39);
        int n = postService.insert(post);
        Assert.assertEquals(n, 1);
    }

    @Test
    public void get(){
        Post post = postService.get(1);
        System.out.println(post.getCreateTime());
        System.out.println(post.getLastTime());
        Assert.assertNotNull(post);
    }

}
