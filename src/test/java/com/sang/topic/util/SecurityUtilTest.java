package com.sang.topic.util;

import org.junit.Test;

public class SecurityUtilTest {
    @Test
    public void test(){
        String password = "123456";
        System.out.println(SecurityUtil.MD5(password));
    }
}
