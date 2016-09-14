package com.sang.topic.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sang.topic.collect.SpiderMap;
import com.sang.topic.collect.processor.TopicPageProcessor;
import com.sang.topic.common.model.Topic;
import com.sang.topic.common.service.TopicUrlService;
import com.sang.topic.common.util.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin/collect")
public class CollectController {
    @Autowired
    TopicUrlService urlService;
    @Autowired
    SpiderMap spiderMap;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("admin/collect/index");
    }

    @ResponseBody
    @RequestMapping(value = "/create")
    public String create() {
        TopicPageProcessor pageProcessor = (TopicPageProcessor) ApplicationContextHelper.getBean("topicPageProcessor");
        pageProcessor.init();
        spiderMap.add(pageProcessor).addUrl("https://v2ex.com");
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll() {
        String result = "";
        try {
            Object o = spiderMap.mapSpider();
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("all result: " + result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String getStatus() {
        String result = "";
        try {
            result = new ObjectMapper().writeValueAsString(spiderMap.mapStatus());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.debug("SpiderMap status: " + result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/{cmd}", method = RequestMethod.POST)
    public String executeSpider(@PathVariable String cmd, String uuid) {
        logger.debug("cmd: " + cmd + " uuid:" + uuid);
        switch (cmd) {
            case "remove":
                spiderMap.remove(uuid);
                break;
            case "pause":
                spiderMap.pause(uuid);
                break;
            case "resume":
                spiderMap.resume(uuid);
                break;
        }
        return "SUCCESS";
    }

}
