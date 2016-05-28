package com.sang.topic.util;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityTest {

    @Test
    public void test(){
        String password = "123456";
        System.out.println(Security.MD5(password));
    }
}
