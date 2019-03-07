package com.maoyan.web.servlet;

import com.maoyan.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IndexServlet",urlPatterns = "/IndexServlet")
public class IndexServlet extends BaseServlet {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/jspPage/Home.jsp";
  }
}
