package com.sang.topic.controller.admin;

import com.sang.topic.common.entity.Topic;
import com.sang.topic.service.TopicService;
import com.sang.topic.common.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/topic")
public class AdminTopicController {
    @Autowired
    private TopicService topicService;

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
