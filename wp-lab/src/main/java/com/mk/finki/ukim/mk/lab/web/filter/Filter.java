package com.mk.finki.ukim.mk.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class Filter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String color=(String) request.getParameter("color");
        String colorSession=(String) request.getSession().getAttribute("color");
        if (colorSession==null)
            colorSession=color;
        String path=request.getServletPath();
        if ( !path.contains("/balloons") && colorSession==null )
            response.sendRedirect("/balloons");
        else
            filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {


    }
}
