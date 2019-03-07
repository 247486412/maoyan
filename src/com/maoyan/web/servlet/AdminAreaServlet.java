package com.maoyan.web.servlet;

import com.maoyan.entity.Area;
import com.maoyan.service.AreaService;
import com.maoyan.service.serviceImpl.AreaServiceImpl;
import com.maoyan.util.UUIDUtils;
import com.maoyan.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminAreaServlet", urlPatterns = "/AdminAreaServlet")
public class AdminAreaServlet extends BaseServlet {
  AreaService areaService = new AreaServiceImpl();

  public String findArea(HttpServletRequest request, HttpServletResponse response) {
	List<Area> areaList = null;
	try {
	  areaList = areaService.findArea();
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "查询失败");
	  return "/admin/category/area/list.jsp";
	}
	request.setAttribute("areaList", areaList);
	return "/admin/category/area/list.jsp";
  }

  public String addAreaUI(HttpServletRequest request, HttpServletResponse response) {
	return "/admin/category/area/add.jsp";
  }

  public String addArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String[] names = request.getParameterValues("name");
	for (String name : names) {
	  Area area = new Area();
	  area.setId(UUIDUtils.getId());
	  area.setName(name);
	  try {
		areaService.addArea(area);
	  } catch (SQLException e) {
		e.printStackTrace();
		request.setAttribute("msg", "添加失败");
		return "/admin/category/area/add.jsp";
	  }
	}
	response.sendRedirect(request.getContextPath() + "/AdminAreaServlet?method=findArea");
	return null;
  }

  public String editAreaUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	String id = request.getParameter("id");
	Area area = areaService.findArea(id);
	request.setAttribute("area", area);
	return "/admin/category/area/edit.jsp";
  }

  public String editArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	Area area = new Area();
	area.setId(id);
	area.setName(name);
	try {
	  areaService.editArea(area);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "修改失败");
	  return "/admin/category/area/edit.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminAreaServlet?method=findArea");
	return null;
  }

  public String deleteArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	try {
	  areaService.deleteArea(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg","删除失败");
	  return "/admin/category/area/list.jsp";
	}
	response.sendRedirect(request.getContextPath()+"/AdminAreaServlet?method=findArea");
	return null;
  }

}
