package com.sang.topic.web.controller;

import com.sang.topic.model.User;
import com.sang.topic.service.UserService;
import com.sang.topic.util.Security;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/u")
public class UserController {
    UserService userService = new UserService();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> create(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        boolean success = false;
        String message = "";
        User u = userService.getByUsername(user.getUsername());
        if (u == null) {
            String newPwd = Security.MD5(user.getPassword());
            user.setPassword(newPwd);
            int n = userService.insert(user);
            if (n > 0) {
                success = true;
            } else {
                message = "注册失败,原因不明";
            }
        } else {
            message = "用户名重复";
        }
        resultMap.put("success", success);
        resultMap.put("message", message);
        return resultMap;
    }

    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    public Map<String, Object> valid(String username, String password, HttpSession httpSession) {
        Map<String, Object> resultMap = new HashMap<>();
        User u = userService.getByUsernameAndPassword(username, Security.MD5(password));
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
        return new ModelAndView("user/editNew");
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
    public Map<String, Object> update(@PathVariable String username, User user, HttpSession httpSession) {
        Map<String, Object> resultMap = new HashMap<>();
        boolean success = false;
        String message = "";
        User sessionUser = (User) httpSession.getAttribute("sessionUser");
        if (sessionUser != null && sessionUser.getUsername().equals(username)) {
            user.setId(sessionUser.getId());
            int n = userService.update(user);
            if (n > 0) {
                success = true;
            } else {
                message = "编辑失败";
            }
        }else{
            message = "请登录后再编辑";
        }
        resultMap.put("success", success);
        resultMap.put("message", message);
        return resultMap;
    }

    @RequestMapping(value = "/{username}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String username) {
        return new ModelAndView("user/edit", "user", userService.getByUsername(username));
    }
}
