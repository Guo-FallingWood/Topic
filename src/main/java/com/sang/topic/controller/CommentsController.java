package com.sang.topic.controller;

import com.sang.topic.model.Comments;
import com.sang.topic.model.User;
import com.sang.topic.service.CommentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by arch on 2016/5/1.
 */
@RestController
public class CommentsController {
    CommentsService commentsService = new CommentsService();

    @ResponseBody
    @RequestMapping(value = "/c", method = RequestMethod.POST)
    public String create(Comments comments, HttpSession httpSession){
        String flag = "error";
        User user = (User) httpSession.getAttribute("sessionUser");
        if(user != null) {
            comments.setUserId(user.getId());
            int n = commentsService.insert(comments);
            if (n > 0)
                flag = "success";
        }
        return flag;
    }
}
