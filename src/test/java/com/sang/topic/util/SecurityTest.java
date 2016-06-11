package com.sang.topic.util;

import org.junit.Test;

public class SecurityTest {
    @Test
    public void test(){
        String password = "123456";
        System.out.println(Security.MD5(password));
    }
}
