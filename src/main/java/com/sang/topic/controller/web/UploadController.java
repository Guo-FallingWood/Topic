package com.sang.topic.controller.web;

import com.sang.topic.common.model.ValidationResponse;
import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.service.UserService;
import com.sang.topic.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by arch on 2016/6/3.
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public ValidationResponse uploadUserPhoto(@RequestParam("photo") MultipartFile file, HttpServletRequest request) {
        try {
            return userService.savePhoto(file, request.getSession());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.failValidation(MessageConstants.UPLOAD_FAIL);
        }
    }
}
