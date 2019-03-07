package com.maoyan.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
  //ServletContextListener服务器启动就会调用此方法,把项目根目录加项目名(/maoyan)存入ServletContext域里,
  // 在jsp页面通过EL表示式${path},可在整个项目中使用
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
	ServletContext servletContext = servletContextEvent.getServletContext();
	servletContext.setAttribute("path",servletContext.getContextPath());
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
  }
}
