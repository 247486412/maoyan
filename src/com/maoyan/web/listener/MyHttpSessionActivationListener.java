package com.maoyan.web.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;
//HttpSessionActivationListener(活化，钝化监听器)，默认服务器关闭session钝化
//要让session的值实现钝化、活化需要实现Serializable(序列化接口)
public class MyHttpSessionActivationListener implements HttpSessionActivationListener, Serializable {
  @Override
  public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
    System.out.println("+666666666666666666");
  }

  @Override
  public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
    System.out.println("+666666666666666666");
  }
}
