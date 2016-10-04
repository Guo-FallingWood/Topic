package com.sang.topic.collect.service;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sh on 2016/9/17.
 */
public class UtilTest {
    @Test
    public void test01(){
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
    public void test02(){
        String url = removeParameter("https://www.v2ex.com/t/305442#reply57");
        System.out.println(url);
        url = removeParameter("https://v2ex.com/t/306321#reply9");
        System.out.println(url);
    }
    @Test
    public void test03(){
        String url = "https://www.v2ex.com/t/305442#reply57";
        String reg = "(https://(?:www\\.)?v2ex\\.com/t/(\\d+)(#reply\\d+)?.*)";
        System.out.println(url.matches(reg));
        url = "https://v2ex.com/t/305483";
        System.out.println(url.matches(reg));

    }

    public static String removeParameter(String url) {
        return url.replaceAll("^(.*)(\\?|#).*$", "$1");
    }
}
