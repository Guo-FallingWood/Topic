package com.sang.topic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arch on 2016/4/23.
 */
@Controller
public class IndexController {

	@RequestMapping(value="/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
}
