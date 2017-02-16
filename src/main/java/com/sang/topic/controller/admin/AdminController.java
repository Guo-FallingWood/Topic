package com.sang.topic.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

    @RequestMapping(value="")
    public ModelAndView index(){
        return new ModelAndView("admin/index");
    }

}
