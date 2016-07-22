package com.sang.topic.admin.controller;

import com.sang.topic.service.UserService;
import com.sang.topic.model.support.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView userIndex(Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("user?p=");

        Map map = new HashMap<String, Object>();
        map.put("users", userService.getByPage(page));
        map.put("page", page);
        return new ModelAndView("admin/user/index", map);
    }
}
