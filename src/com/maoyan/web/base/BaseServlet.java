package com.maoyan.web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class BaseServlet extends HttpServlet {
  @Override
  public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String method = req.getParameter("method");//传过来的参数没有method就执行execute方法
	if (null == method || "".equals(method) || method.trim().equals("")) {
	  method = "execute";
	}
	// 注意:此处的this代表的是子类的对象
	Class clazz = this.getClass();
	try {
	  // 查找子类对象对应的字节码中的名称为method的方法.这个方法的参数类型是:HttpServletRequest.class,HttpServletResponse.class
	  Method md = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
	  if (null != md) {
		String jspPath = (String) md.invoke(this, req, resp);
		if (null != jspPath) {
		  req.getRequestDispatcher(jspPath).forward(req, resp);
		}
	  }
	} catch (Exception e) {
	  e.printStackTrace();
	}

  }

  // 默认方法
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, Exception {
	return null;
  }

}