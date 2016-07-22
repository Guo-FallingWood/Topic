package com.sang.topic.admin.controller;

import com.sang.topic.service.CommentsService;
import com.sang.topic.model.support.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/comments")
public class AdminCommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView commentsIndex(Integer postId, Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("comments?p=");

        Map map = new HashMap<String, Object>();
        map.put("comments", commentsService.getCommentsByPostIdAndPage(postId, page));
        map.put("page", page);
        return new ModelAndView("admin/comments/index", map);
    }

}
