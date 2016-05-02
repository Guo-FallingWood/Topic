package com.sang.topic.controller;

import com.sang.topic.service.UserService;
import com.sang.topic.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arch on 2016/5/2.
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
    UserService userService = new UserService();

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

}
