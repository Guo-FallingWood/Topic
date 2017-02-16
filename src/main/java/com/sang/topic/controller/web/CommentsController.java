package com.sang.topic.controller.web;

import com.sang.topic.common.entity.Comments;
import com.sang.topic.common.entity.User;
import com.sang.topic.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @RequestMapping(value = "/c", method = RequestMethod.POST)
    public Map<String, Object> create(String content, Integer post_id, HttpSession httpSession){
        Map<String, Object> resultMap = new HashMap<>();
        boolean success = false;
        String message = "";
        Comments comments = new Comments();
        comments.setContent(content);
        comments.setPostId(post_id);
        User user = (User) httpSession.getAttribute("sessionUser");
        if(user != null) {
            comments.setContent(HtmlUtils.htmlEscape(comments.getContent()));
            comments.setUserId(user.getId());
            int n = commentsService.insert(comments);
            if (n > 0)
                success = true;
            else message = "回复失败";
        }else{
            message = "请登录后再回复";
        }
        resultMap.put("success", success);
        resultMap.put("message", message);
        return resultMap;
    }
}
