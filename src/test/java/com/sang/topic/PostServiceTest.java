package com.sang.topic;

import com.sang.topic.model.Post;
import com.sang.topic.service.PostService;
import com.sang.topic.util.Page;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/4/29.
 */
public class PostServiceTest {

    PostService postService;

    @Before
    public void setup(){
        postService = new PostService();
    }

    @Test
    public void selectByPage(){
        Page page = new Page();
        page.setPageSize(2);
        page.setCurrentPage(3);
        List<Post> list = postService.getByPage(page);
        System.out.println(list.size());
    }

    @Test
    public void selectByTopicAndPage(){
        Page page = new Page();
        page.setCurrentPage(2);
        List<Post> list = postService.getByTopicAndPage(1, page);
        System.out.println(list.size());
    }

}
