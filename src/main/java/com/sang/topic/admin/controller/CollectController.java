package com.sang.topic.admin.controller;

import com.sang.topic.collect.SpiderExecutor;
import com.sang.topic.common.model.CollectRule;
import com.sang.topic.common.model.Post;
import com.sang.topic.common.service.CollectRuleService;
import com.sang.topic.common.service.CollectUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/collect")
public class CollectController {
    @Autowired
    CollectUrlService urlService;
    @Autowired
    CollectRuleService ruleService;
    @Autowired
    SpiderExecutor spiderExecutor;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("admin/collect/index");
    }

    @ResponseBody
    @RequestMapping(value = "/rule/test/{id}")
    public Post ruleTest(@PathVariable int id, String url) {
        logger.debug("Test begin. rule id:" + id + " url:" + url);
        CollectRule collectRule = ruleService.get(id);
        Post post = spiderExecutor.run(collectRule, url);
        logger.debug("Test done. (rule) id:" + id + " url:" + url +
                " (post) title:" + post.getTitle());
        return post;
    }

    @ResponseBody
    @RequestMapping(value = "/rule")
    public List<CollectRule> ruleAll() {
        return ruleService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    public String ruleAdd(String name) {
        ruleService.insert(name);
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping(value = "/rule/{id}", method = RequestMethod.GET)
    public CollectRule ruleAdd(@PathVariable int id) {
        return ruleService.get(id);
    }

    @ResponseBody
    @RequestMapping(value = "/rule/{id}", method = RequestMethod.PUT)
    public String ruleUpdate(CollectRule collectRule) {
        logger.debug("id " + collectRule.getId() + " name " + collectRule.getName());
        ruleService.update(collectRule);
        return "SUCCESS";
    }
}
