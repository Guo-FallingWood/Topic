package com.sang.topic.controller;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by arch on 2016/4/23.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	UserService userService = new UserService();

	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(User user){
        String flag = "error";
		int n = userService.insert(user);
        if(n > 0)
            flag = "success";
        return flag;
	}

    @RequestMapping(value="/valid", method=RequestMethod.POST)
    public String valid(String username, String password, HttpSession httpSession){
        String flag = "error";
        User u = userService.valid(username, password);
        if(u != null) {
            httpSession.setAttribute("sessionUser", u);
            flag = "success";
        }
        return flag;
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("user/login");
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession){
        httpSession.invalidate();
        return login();
    }

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView editNew(){
        return new ModelAndView("user/editNew");
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ModelAndView show(@PathVariable Integer userId){
		return new ModelAndView("user/show", "user", userService.get(userId));
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.PUT)
	public String update(@PathVariable Integer userId, User user){
        String flag = "error";
		int n = userService.update(user);
        if(n > 0)
            flag = "success";
        return flag;
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer userId){
        String flag = "error";
		int n = userService.delete(userId);
        if(n > 0)
            flag = "success";
        return flag;
	}

	@RequestMapping(value="/{userId}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable Integer userId){
		return new ModelAndView("user/edit", "user", userService.get(userId));
	}
}
