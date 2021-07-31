package com.myapp1.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminLoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        String uri = request.getRequestURI();
        if(uri.startsWith("/admin") && (!uri.endsWith("login")&&!uri.endsWith("register")) && null == request.getSession().getAttribute("user")){
            request.getSession().setAttribute("error", "log again");
            response.sendRedirect(request.getContextPath() + "/admin_login");
            return false;
        }
        else{
            return true;
        }
    }
}
