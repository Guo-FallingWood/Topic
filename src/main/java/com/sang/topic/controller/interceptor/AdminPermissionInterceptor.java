package com.sang.topic.controller.interceptor;

import com.sang.topic.common.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("sessionUser");
        if(user != null) {
            if(user.getRoleId() == 1){
                return super.preHandle(request, response, handler);
            }
            response.sendError(403);
        }else {
            response.sendError(404);
        }
        return false;
    }

}
