package com.sang.topic.web.controller;

import com.sang.topic.model.Post;
import com.sang.topic.model.Topic;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.model.support.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TopicController {

    PostService postService = new PostService();
    TopicService topicService = new TopicService();

	@RequestMapping(value="/")
	public ModelAndView index(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("/?p=");

        List<Topic> topics = topicService.getAll();
        List<Post> posts = postService.getByPage(page);

        Map<String, Object> map = new HashMap<>();
        map.put("topics", topics);
        map.put("posts", posts);
        map.put("page", page);
        return new ModelAndView("topic/index", map);
	}

	@RequestMapping(value="/t/{id}")
    public ModelAndView topic(@PathVariable Integer id, Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("/t/"+id+"?p=");

        List<Topic> topics = topicService.getAll();
        List<Post> posts = postService.getByTopicAndPage(id, page);

        Map<String, Object> map = new HashMap<>();
        map.put("topics", topics);
        map.put("posts", posts);
        map.put("page", page);
        return new ModelAndView("topic/index", map);
    }

}
