package com.sang.topic.admin.controller;

import com.sang.topic.model.Topic;
import com.sang.topic.service.TopicService;
import com.sang.topic.util.AjaxResultMap;
import com.sang.topic.util.Page;
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
    public ModelAndView topicIndex(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("topic?p=");

        Map map = new HashMap<String, Object>();
        map.put("topics", topicService.getAll());
        map.put("page", page);
        return new ModelAndView("admin/topic/index", map);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Map<String, Object> topicCreate(Topic topic){
        boolean success = false;
        String message = "";
        int n = topicService.insert(topic);
        if(n > 0)
            success = true;
        else message = "添加话题失败";
        return new AjaxResultMap(success, message);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Map<String, Object> topicUpdate(@PathVariable int id, int discard){
        boolean success = false;
        String message = "";
        Topic topic = new Topic();
        topic.setId(id);
        topic.setClose(discard);
        int n = topicService.update(topic);
        if(n > 0)
            success = true;
        else message = "修改话题失败";
        return new AjaxResultMap(success, message);
    }

}
