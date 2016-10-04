package com.sang.topic.collect.service;

import com.sang.topic.collect.SpiderExecutor;
import com.sang.topic.collect.processor.TopicPageProcessor;
import com.sang.topic.common.util.ApplicationContextHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sh on 2016/9/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-webmagic.xml",
        "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml", "classpath:spring.xml"})
public class TopicPageProcessorTest {
    SpiderExecutor map = SpiderExecutor.getInstance();

    @Test
    public void test01(){
        TopicPageProcessor processor = (TopicPageProcessor) ApplicationContextHelper.getBean("topicPageProcessor");
//        map.add(processor).addUrl("https://v2ex.com");
    }

}
