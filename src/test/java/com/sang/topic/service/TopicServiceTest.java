package com.sang.topic.service;

import com.sang.topic.service.TopicService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by arch on 2016/4/29.
 */
public class TopicServiceTest {
    TopicService topicService;

    @Before
    public void setup(){
        topicService = new TopicService();
    }

    @Test
    public void selectAll(){
        List list = topicService.getAll();
        System.out.println(list.size());
    }

}
