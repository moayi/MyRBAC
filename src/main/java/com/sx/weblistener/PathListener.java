package com.sx.weblistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * moayi
 *
 * @create 2018-06-07 9:11
 **/
public class PathListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext app = servletContextEvent.getServletContext();
        String contextPath = app.getContextPath();
        app.setAttribute("RBAC",contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}