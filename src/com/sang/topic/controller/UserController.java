package com.sang.topic.controller;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arch on 2016/4/23.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	UserService userService = new UserService();

	@RequestMapping(value="/valid", method=RequestMethod.POST, consumes="application/json")
	public ModelAndView valid(@RequestBody User user){
		return new ModelAndView();
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("user/index", "models", userService.getAll());
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView create(User user){
		userService.insert(user);
//		return show(user.getId());
		return index();
	}

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView editNew(){
		ModelAndView view = new ModelAndView();
		view.setViewName("user/editNew");
		return view;
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ModelAndView show(@PathVariable Integer userId){
		return new ModelAndView("user/show", "model", userService.get(userId));
//		return index();
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.PUT)
	public ModelAndView update(@PathVariable Integer userId, User user){
		userService.update(user);
//		return show(userId);
		return index();
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Integer userId){
		userService.delete(userId);
		return index();
	}

	@RequestMapping(value="/{userId}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable Integer userId){
		return new ModelAndView("user/edit", "model", userService.get(userId));
	}
}
