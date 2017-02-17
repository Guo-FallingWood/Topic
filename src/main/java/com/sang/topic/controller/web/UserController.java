package com.sang.topic.controller.web;

import com.sang.topic.common.entity.User;
import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import com.sang.topic.common.model.ValidationResponse;
import com.sang.topic.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "/u")
@SessionAttributes(names = "sessionUser")
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.removeAttribute("sessionUser");
        httpSession.invalidate();
        return new ModelAndView("user/logout");
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView editNew() {
        ModelAndView modelAndView = new ModelAndView("user/editNew");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable String username, HttpServletResponse response)
            throws IOException {
        User user = userService.getByUsername(username);
        if (user == null)
            response.sendError(404);
        return new ModelAndView("user/show", "user", user);
    }

    @RequestMapping(value = "/{username}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String username) {
        return new ModelAndView("user/edit", "user", userService.getByUsername(username));
    }

    /**
     * 注册用户
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ValidationResponse create(@ModelAttribute @Valid User user, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return ResponseUtil.failFieldValidation(bindingResult.getFieldErrors());
        }
        ValidationResponse res = userService.create(user);
        if (res.success()) {
            User u = userService.getByUsername(user.getUsername());
            httpSession.setAttribute("sessionUser", u);
        }
        return res;
    }

    /**
     * 验证用户名和密码
     */
    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    public ValidationResponse valid(String username, String password, HttpSession httpSession) {
        User u = userService.getByUsernameAndPassword(username, SecurityUtil.MD5(password));
        if (u != null) {
            httpSession.setAttribute("sessionUser", u);
            return ResponseUtil.successValidation(MessageConstants.USER_LOGIN_SUCCESS);
        }
        return ResponseUtil.failValidation(MessageConstants.USER_LOGIN_FAIL);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public ValidationResponse update(@PathVariable String username, @Valid User user,
                                     BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return ResponseUtil.failFieldValidation(bindingResult.getFieldErrors());
        } else {
            return userService.save(user, httpSession);
        }
    }

    @RequestMapping(value="/loginMessage", method = RequestMethod.GET)
    public ValidationResponse loginMessage(){
        return ResponseUtil.failValidation(MessageConstants.USER_LOGIN_REQUIRE);
    }
}
