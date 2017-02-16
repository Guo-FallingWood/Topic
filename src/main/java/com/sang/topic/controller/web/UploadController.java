package com.sang.topic.controller.web;

import com.sang.topic.common.entity.User;
import com.sang.topic.service.UserService;
import com.sang.topic.common.model.AjaxResultMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by arch on 2016/6/3.
 */
@RestController
public class UploadController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public AjaxResultMap uploadUserPhoto(@RequestParam("photo") MultipartFile file, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("sessionUser");
        String message;
        boolean success = false;
        Set<String> suffixes = new HashSet<>();
        suffixes.add("png");
        suffixes.add("jpg");
        try {
            if (user != null) {
                if (!file.isEmpty()) {
                    String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
                    if(suffixes.contains(suffix)) {
                        byte[] bytes = file.getBytes();
                        String filename = UUID.randomUUID().toString()+"."+suffix;
                        String filepath = request.getSession().getServletContext().
                                getRealPath("/resource/upload/photo/");
                        File newFile = new File(filepath+"/"+filename);
                        FileUtils.writeByteArrayToFile(newFile, bytes);

                        user.setPhoto(filename);
                        int n = userService.update(user);
                        if(n > 0) {
                            message = "上传成功";
                            success = true;
                        }else{
                            message = "上传失败";
                        }
                    }else{
                        message = "不支持此文件类型";
                    }
                } else {
                    message = "文件为空";
                }
            } else {
                message = "请先登录在进行操作";
            }
        } catch (IOException e) {
            e.printStackTrace();
            message = "文件传输异常";
        }
        return new AjaxResultMap(success, message);
    }
}
