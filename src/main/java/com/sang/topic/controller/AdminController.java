package com.sang.topic.controller;

import com.sang.topic.model.Topic;
import com.sang.topic.service.CommentsService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import com.sang.topic.util.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arch on 2016/5/2.
 */
@RestController
@RequestMapping(value="/admin")
public class AdminController {
    UserService userService = new UserService();
    TopicService topicService = new TopicService();
    PostService postService = new PostService();
    CommentsService commentsService = new CommentsService();

    @RequestMapping(value="")
    public ModelAndView index(){
        return new ModelAndView("admin/index");
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ModelAndView userIndex(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("user?p=");

        Map map = new HashMap<String, Object>();
        map.put("users", userService.getByPage(page));
        map.put("page", page);
        return new ModelAndView("admin/userIndex", map);
    }

    @RequestMapping(value="/topic", method = RequestMethod.GET)
    public ModelAndView topicIndex(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("topic?p=");

        Map map = new HashMap<String, Object>();
        map.put("topics", topicService.getAll());
        map.put("page", page);
        return new ModelAndView("admin/topicIndex", map);
    }

    @RequestMapping(value="/topic", method = RequestMethod.POST)
    public String topicCreate(Topic topic){
        String flag = "error";
        int n = topicService.insert(topic);
        if(n > 0)
            flag = "success";
        return flag;
    }

    @RequestMapping(value="/topic/{id}", method = RequestMethod.PUT)
    public String topicUpdate(@PathVariable int id, int discard){
        String flag = "error";
        Topic topic = new Topic();
        topic.setId(id);
        topic.setClose(discard);
        int n = topicService.update(topic);
        if(n > 0)
            flag = "success";
        return flag;
    }

    @RequestMapping(value="/post", method = RequestMethod.GET)
    public ModelAndView postIndex(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("post?p=");

        Map map = new HashMap<String, Object>();
        map.put("posts", postService.getByPage(page));
        map.put("page", page);
        return new ModelAndView("admin/postIndex", map);
    }

    @RequestMapping(value="/post/{postId}/comments", method = RequestMethod.GET)
    public ModelAndView commentsIndex(@PathVariable Integer postId, Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("comments?p=");

        Map map = new HashMap<String, Object>();
        map.put("comments", commentsService.getCommentsByPostIdAndPage(postId, page));
        map.put("page", page);
        return new ModelAndView("admin/commentsIndex", map);
    }

}
