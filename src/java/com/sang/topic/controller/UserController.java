package com.sang.topic.controller;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import com.sang.topic.util.Page;
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
@Controller
@RequestMapping(value="/user")
public class UserController {
	UserService userService = new UserService();

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView index(Integer p){
        int rowNumber = userService.selectCount();
        Page page = new Page(rowNumber, "user?p=");
        if(p != null)
            page.setCurrentPage(p);

        Map map = new HashMap<String, Object>();
        map.put("models", userService.selectByPage(page.toRowBounds()));
        map.put("page", page);
        return new ModelAndView("user/index", map);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView create(User user){
		userService.insert(user);
//		return show(user.getId());
		return index(1);
	}

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView login(User user, HttpSession httpSession){
        User u = userService.valid(user.getUsername(), user.getPassword());
        if(u != null)
            httpSession.setAttribute("userId", u.getId());
        return new ModelAndView();
    }

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView editNew(){
        return new ModelAndView("user/editNew");
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
		return index(1);
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
