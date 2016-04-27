package com.sang.topic.controller;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import com.sang.topic.util.Page;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arch on 2016/4/23.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	UserService userService = new UserService();

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView index(Integer p){
		Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("user?p=");

        Map map = new HashMap<String, Object>();
        map.put("models", userService.selectByPage(page));
        map.put("page", page);
        return new ModelAndView("user/index", map);
	}

    @ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public User create(User user){
		int n = userService.insert(user);
        if(n>0)
            return user;
        return null;
	}

    @ResponseBody
    @RequestMapping(value="/valid", method=RequestMethod.POST)
    public User valid(String username, String password, HttpSession httpSession){
        User u = userService.valid(username, password);
        if(u != null) {
            httpSession.setAttribute("sessionUser", u);
            return u;
        }
        else return null;
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
		return new ModelAndView("user/show", "model", userService.get(userId));
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.PUT)
	public ModelAndView update(@PathVariable Integer userId, User user){
		userService.update(user);
		return show(userId);
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Integer userId){
		userService.delete(userId);
		return index(1);
	}

	@RequestMapping(value="/{userId}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable Integer userId){
		return new ModelAndView("user/edit", "model", userService.get(userId));
	}
}
