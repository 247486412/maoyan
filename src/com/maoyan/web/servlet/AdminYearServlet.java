package com.maoyan.web.servlet;

import com.maoyan.entity.Year;
import com.maoyan.service.YearService;
import com.maoyan.service.serviceImpl.YearServiceImpl;
import com.maoyan.util.UUIDUtils;
import com.maoyan.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminYearServlet", urlPatterns = "/AdminYearServlet")
public class AdminYearServlet extends BaseServlet {
  YearService yearService = new YearServiceImpl();

  public String findAllYear(HttpServletRequest request, HttpServletResponse response) {
	List<Year> yearList = null;
	try {
	  yearList = yearService.findYear();
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "查询失败");
	  return "/admin/category/year/list.jsp";
	}
	request.setAttribute("yearList", yearList);
	return "/admin/category/year/list.jsp";
  }

  public String addYearUI(HttpServletRequest request, HttpServletResponse response) {
	return "/admin/category/year/add.jsp";
  }

  public String addYear(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String[] names = request.getParameterValues("name");
	for (String name : names) {
	  Year year = new Year();
	  year.setId(UUIDUtils.getId());
	  year.setName(name);
	  try {
		yearService.addYear(year);
	  } catch (SQLException e) {
		e.printStackTrace();
		request.setAttribute("msg", "添加失败");
		return "/admin/category/year/add.jsp";
	  }
	}
	response.sendRedirect(request.getContextPath() + "/AdminYearServlet?method=findAllYear");
	return null;
  }

  public String deleteYear(HttpServletRequest request, HttpServletResponse response) throws IOException {
  String id = request.getParameter("id");
	try {
	  yearService.deleteYear(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg","删除失败");
	  return "/admin/category/year/list.jsp";
	}
	response.sendRedirect(request.getContextPath()+"/AdminYearServlet?method=findAllYear");
  return null;
  }
  public String editYearUI(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
    String id = request.getParameter("id");
	Year year = yearService.findYear(id);
	request.setAttribute("year",year);
    return "/admin/category/year/edit.jsp";
  }
  public String editYear(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    Year year = new Year();
    year.setId(id);
    year.setName(name);
	try {
	  yearService.editYear(year);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg","修改失败");
	  return "/admin/category/year/edit.jsp";
	}
	response.sendRedirect(request.getContextPath()+"/AdminYearServlet?method=findAllYear");
    return null;
  }


}
