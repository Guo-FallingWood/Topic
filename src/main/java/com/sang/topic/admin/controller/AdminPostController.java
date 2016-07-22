package com.sang.topic.admin.controller;

import com.sang.topic.service.PostService;
import com.sang.topic.model.support.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/post")
public class AdminPostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView postIndex(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("post?p=");

        Map map = new HashMap<String, Object>();
        map.put("posts", postService.getByPage(page));
        map.put("page", page);
        return new ModelAndView("admin/post/index", map);
    }

}
