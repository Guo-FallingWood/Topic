package com.sang.topic;

import com.sang.topic.model.Post;
import com.sang.topic.service.PostService;
import com.sang.topic.util.DateConverter;
import org.junit.Test;

/**
 * Created by arch on 2016/5/5.
 */
public class DateFormatTest {

    @Test
    public void dateFormatTest(){
        PostService postService = new PostService();
        Post post = postService.get(2);
        System.out.println(DateConverter.convert(post.getCreateTime()));
        System.out.println(DateConverter.convert(post.getLastTime()));
    }

}
