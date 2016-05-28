package com.sang.topic.service;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
