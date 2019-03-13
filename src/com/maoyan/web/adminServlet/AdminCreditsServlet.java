package com.maoyan.web.adminServlet;

import com.maoyan.service.CreditsService;
import com.maoyan.service.serviceImpl.CreditsServiceImpl;
import com.maoyan.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "AdminCreditsServlet", urlPatterns = "/AdminCreditsServlet")
public class AdminCreditsServlet extends BaseServlet {
  private CreditsService creditsService = new CreditsServiceImpl();

  public String findCredits(HttpServletRequest request, HttpServletResponse response) {
	String id = request.getParameter("id");
	Map creditsMap = null;
	try {
	  creditsMap = creditsService.findCredits(id);
	  if (creditsMap == null) {
		response.sendRedirect(request.getContextPath() + "/admin/category/credits/list.jsp");
	  }
	} catch (SQLException | IOException e) {
	  e.printStackTrace();
	}
	request.setAttribute("creditsMap", creditsMap);
	return "/admin/category/credits/list.jsp";
  }

  public String deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	try {
	  creditsService.deleteAll(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "删除失败");
	  return "/admin/category/credits/list.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminCreditsServlet?method=findCredits&id="+id);
	return null;
  }

  public String deleteCredits(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String fieldName = request.getParameter("fieldName");
	String id = request.getParameter("id");
	try {
	  creditsService.deleteCredits(id, fieldName);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "删除失败");
	  return "/admin/category/credits/list.jsp";
	}
	response.sendRedirect(request.getContextPath() + "//AdminCreditsServlet?method=findCredits&id="+id);
	return null;
  }

  public String addCreditsUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	String id = request.getParameter("id");
	String type = request.getParameter("type");
	Map creditsMap = creditsService.findCredits(id);
	request.setAttribute("type", type);
	request.setAttribute("id", id);
	request.setAttribute("creditsMap", creditsMap.get(type));
	return "/admin/category/credits/add.jsp";
  }

  public String addCredits(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	String[] name = request.getParameterValues("name");
	String type = request.getParameter("type");
	String creditsName = request.getParameter("creditsName");
	for (String n : name) {
	  creditsName += "，" + n;
	}
	if (creditsName.startsWith("，")) {
	  creditsName = creditsName.substring(1);
	}
	try {
	  creditsService.addCredits(id, creditsName, type);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "添加失败");
	  return "/admin/category/credits/list.jsp";
	}

	response.sendRedirect(request.getContextPath() + "/AdminCreditsServlet?method=findCredits&id="+id);
	return null;
  }

  public String editCreditsUI(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
    String id = request.getParameter("id");
    String type = request.getParameter("type");
	Map<String ,Map<String,String>> creditsMap = creditsService.findCredits(id);
	String name= "";
	for (Map.Entry<String,String> entry:creditsMap.get(type).entrySet()){
	  name=entry.getValue();
	  request.setAttribute("name", entry.getKey());
	}
	String [] names = name.split("，");
	request.setAttribute("names",Arrays.asList(names));
	request.setAttribute("id",id);
	request.setAttribute("type",type);
	return "/admin/category/credits/edit.jsp";
  }

  public String editCredits(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String id = request.getParameter("id");
    String type = request.getParameter("type");
    String[] names = request.getParameterValues("name");
    String creditsName = "";
	for (String n : names) {
	  creditsName += "，" + n;
	}
	creditsName = creditsName.substring(1);
	try {
	  creditsService.addCredits(id, creditsName, type);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg","修改失败");
	  return "/admin/category/credits/edit.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminCreditsServlet?method=findCredits&id="+id);
	return null;
  }


}
