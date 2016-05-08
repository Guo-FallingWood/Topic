package com.sang.topic.interceptor;


import com.sang.topic.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by arch on 2016/5/8.
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("sessionUser");
        if(user != null) {
            if(user.getRoleId() != 1){
                response.sendError(403);
            }
            return super.preHandle(request, response, handler);
        }
        response.sendRedirect("/user/login");
        return false;
    }

}
