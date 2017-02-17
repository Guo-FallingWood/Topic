package com.sang.topic.controller.web;

import com.sang.topic.common.entity.Comments;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.ValidationResponse;
import com.sang.topic.service.CommentsService;
import com.sang.topic.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/c")
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    /**
     * 发表评论
     *
     * @param comments
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ValidationResponse create(@ModelAttribute @Valid Comments comments, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors())
            return ResponseUtil.failFieldValidation(bindingResult);
        User user = (User) httpSession.getAttribute("sessionUser");
        comments.setUserId(user.getId());
        return commentsService.create(comments);
    }
}
