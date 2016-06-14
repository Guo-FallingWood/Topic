package com.sang.topic.admin.controller;

import com.sang.topic.model.Topic;
import com.sang.topic.service.TopicService;
import com.sang.topic.model.support.AjaxResultMap;
import com.sang.topic.model.support.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/topic")
public class AdminTopicController {
    TopicService topicService = new TopicService();

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("topic?p=");

        Map map = new HashMap<String, Object>();
        map.put("topics", topicService.getAll());
        map.put("page", page);
        return new ModelAndView("admin/topic/index", map);
    }


}
