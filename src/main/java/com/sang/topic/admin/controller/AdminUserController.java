package com.sang.topic.admin.controller;

import com.sang.topic.common.service.UserService;
import com.sang.topic.common.model.support.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView userIndex(Model model, Integer p) {
        Page page = new Page();
        if (p != null) page.setCurrentPage(p);
        page.setUrl("user?p=");

        model.addAttribute("users", userService.getByPage(page));
        model.addAttribute("page", page);
        new ModelAndView();
        return new ModelAndView("admin/user/index");
    }
}
