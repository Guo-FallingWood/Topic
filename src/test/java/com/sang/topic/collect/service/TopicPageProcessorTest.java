package com.sang.topic.collect.service;

import com.sang.topic.collect.SpiderMap;
import com.sang.topic.common.service.TopicUrlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sh on 2016/9/11.
 */
public class TopicPageProcessorTest {
    SpiderMap map = SpiderMap.getInstance();

    @Test
    public void test00(){
        String reg = "^https://(?:www\\.)?v2ex\\.com/t/(\\d+)(?:#reply\\d+)?.*$";
        String url = "https://v2ex.com/t/305442";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(url);
        if(m.find()){
            System.out.println(m.group(0));
            System.out.println(m.group(1));
        }
    }

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-mvc.xml", "spring-mybatis.xml"});
        TopicUrlService urlService = (TopicUrlService) context.getBean("urlService");
//        TopicPageProcessor processor = new TopicPageProcessor();
//        map.add(processor);
//        String url = "https://www.v2ex.com/t/305442#reply57";
//        String reg = "(https://(?:www\\.)?v2ex\\.com/t/(\\d+)(#reply\\d+)?.*)";
//        System.out.println(url.matches(reg));
//        url = "https://v2ex.com/t/305483";
//        System.out.println(url.matches(reg));
    }

    @Test
    public void test02(){
        String url = removeParameter("https://www.v2ex.com/t/305442#reply57");
        System.out.println(url);
        url = removeParameter("https://www.v2ex.com/t/305442?id=10");
        System.out.println(url);
    }

    public static String removeParameter(String url) {
        return url.replaceAll("^(.*)(\\?|#).*$", "$1");
    }
}
