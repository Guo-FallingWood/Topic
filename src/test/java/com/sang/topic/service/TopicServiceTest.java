package com.sang.topic.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class TopicServiceTest {
    @Autowired
    TopicService topicService;

    @Before
    public void setup(){
    }

    @Test
    public void selectAll(){
        List list = topicService.getAll();
        System.out.println(list.size());
    }

}
