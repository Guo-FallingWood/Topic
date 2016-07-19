package com.sang.topic.admin.controller;

import com.sang.topic.model.Topic;
import com.sang.topic.service.TopicService;
import com.sang.topic.model.support.AjaxResultMap;
import com.sang.topic.model.support.Page;
import com.sun.org.apache.xml.internal.security.signature.ObjectContainer;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/topic")
public class AdminTopicController {
    TopicService topicService = new TopicService();

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(Integer p) {
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("topic?p=");

        Map map = new HashMap<String, Object>();
        map.put("topics", topicService.getAll());
        map.put("page", page);
        return new ModelAndView("admin/topic/index", map);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> create(@ModelAttribute Topic topic) {
        Map<String, Object> resultMap = new HashMap<>();
        int n = topicService.insert(topic);
        if(n > 0){
            resultMap.put("success", true);
        }
        return resultMap;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Map<String, Object> update(@PathVariable Integer id, Integer discard){
        Map<String, Object> resultMap = new HashMap<>();
        if(id != null && discard != null ){
            Topic topic = topicService.get(id);
            topic.setClose(discard);
            if(topic != null){
                topicService.update(topic);
                resultMap.put("success", true);
                return resultMap;
            }
        }
        resultMap.put("success", false);
        resultMap.put("message", "失败");
        return resultMap;
    }

}
