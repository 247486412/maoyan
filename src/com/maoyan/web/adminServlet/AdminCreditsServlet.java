package com.maoyan.web.adminServlet;

import com.maoyan.entity.Credits;
import com.maoyan.service.CreditsService;
import com.maoyan.service.serviceImpl.CreditsServiceImpl;
import com.maoyan.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet(name = "AdminCreditsServlet",urlPatterns = "/AdminCreditsServlet")
public class AdminCreditsServlet extends BaseServlet {
  private CreditsService creditsService = new CreditsServiceImpl();
public String findCredits(HttpServletRequest request, HttpServletResponse response){
  String id = request.getParameter("id");
  Credits credits = null;
  try {
	credits = creditsService.findCredits(id);
  } catch (SQLException e) {
	e.printStackTrace();
  }
  request.setAttribute("credits",credits);
  return "/admin/category/credits/list.jsp";
}
}
