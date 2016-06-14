package com.sang.topic.web.controller;

import com.sang.topic.model.support.ErrorMessage;
import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import com.sang.topic.model.support.ValidationResponse;
import com.sang.topic.util.ValidationUtil;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/u")
public class UserController {
    UserService userService = new UserService();
    Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ValidationResponse create(@Valid User user, BindingResult bindingResult) {
        ValidationResponse response = new ValidationResponse();
        List<ErrorMessage> errors = null;
        if(bindingResult.hasErrors()) {
            errors = ValidationUtil.FieldErrorsToErrorMessages(bindingResult.getFieldErrors());
        }else{
            User u = userService.getByUsername(user.getUsername());
            if (u == null) {
                String newPwd = SecurityUtil.MD5(user.getPassword());
                user.setPassword(newPwd);
                int n = userService.insert(user);
                if (n > 0) {
                    response.setStatus("SUCCESS");
                }
            } else {
                errors = new ArrayList<>();
                errors.add(new ErrorMessage("username", "用户名重复"));
            }
        }
        response.setErrors(errors);
        return response;
    }

    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    public Map<String, Object> valid(String username, String password, HttpSession httpSession) {
        Map<String, Object> resultMap = new HashMap<>();
        User u = userService.getByUsernameAndPassword(username, SecurityUtil.MD5(password));
        if (u != null) {
            httpSession.setAttribute("sessionUser", u);
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "用户名或密码错误");
        }
        return resultMap;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ModelAndView("redirect:/u/login");
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
        if(user == null)
            response.sendError(404);
        return new ModelAndView("user/show", "user", user);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public ValidationResponse update(@PathVariable String username, @Valid User user,
                                      BindingResult bindingResult, HttpSession httpSession) {
        ValidationResponse response = new ValidationResponse();
        List<ErrorMessage> errors = null;
        if(bindingResult.hasErrors()){
            errors = ValidationUtil.FieldErrorsToErrorMessages(bindingResult.getFieldErrors());
        }else {
            errors = new ArrayList<>();
            User sessionUser = (User) httpSession.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUsername().equals(username)) {
                user.setId(sessionUser.getId());
                int n = userService.update(user);
                if (n > 0) {
                    response.setStatus("SUCCESS");
                }else{
                    errors.add(new ErrorMessage("alert", "更新错误"));
                }
            } else {
                errors.add(new ErrorMessage("alert", "登录后评论"));
            }
        }
        response.setErrors(errors);
        return response;
    }

    @RequestMapping(value = "/{username}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String username) {
        return new ModelAndView("user/edit", "user", userService.getByUsername(username));
    }
}
