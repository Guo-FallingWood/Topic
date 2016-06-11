package com.sang.topic.util;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

/**
 * Created by arch on 2016/6/3.
 */
public class FileUploadTest {

    @Test
    public void test(){
        String filename = "c://dsds/dsdsd/d/abc.png";
        String filename2 = "c://dsds/dsdsd/d/abc";
        System.out.println(FilenameUtils.getExtension(filename));
        System.out.println(FilenameUtils.getExtension(filename2));
    }
}
