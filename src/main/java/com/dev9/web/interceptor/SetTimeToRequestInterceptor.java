package com.dev9.web.interceptor;

import org.joda.time.DateTime;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetTimeToRequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // add an attribute to the request
        request.setAttribute("requestStarted", new DateTime().toString("hh:mm:ss"));
        return super.preHandle(request, response, handler);
    }
}
