package com.maoyan.web.servlet;

import com.maoyan.entity.Type;
import com.maoyan.service.TypeService;
import com.maoyan.service.serviceImpl.TypeServiceImpl;
import com.maoyan.util.UUIDUtils;
import com.maoyan.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminTypeServlet",urlPatterns = "/AdminTypeServlet")
public class AdminTypeServlet extends BaseServlet {
  private TypeService typeService = new TypeServiceImpl();
  public String findAllType(HttpServletRequest request,HttpServletResponse response){
    List<Type> typeList = null;
    try {
      typeList = typeService.findAllType();
    } catch (SQLException e) {
      e.printStackTrace();
      request.setAttribute("msg","查询失败");
      return "/admin/category/type/list.jsp";
    }
    request.setAttribute("typeList",typeList);
    return "/admin/category/type/list.jsp";
  }
  public String addTypeUI(HttpServletRequest request,HttpServletResponse response){
    return "/admin/category/type/add.jsp";
  }
  public String addType(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    String[] name = request.getParameterValues("name");
    for (String typeName:name){
      Type type = new Type();
      type.setId(UUIDUtils.getId());
      type.setName(typeName);
      try {
        typeService.addType(type);
      } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("msg","添加失败");
        request.getRequestDispatcher("/admin/category/type/add.jsp").forward(request,response);
      }
    }
    response.sendRedirect(request.getContextPath()+"/AdminTypeServlet?method=findAllType");
    return null;
  }

  public String deleteType(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    String id  = request.getParameter("id");
    try {
      typeService.deleteType(id);
    } catch (SQLException e) {
      e.printStackTrace();
      request.setAttribute("msg","删除失败");
      request.getRequestDispatcher("/admin/category/type/list.jsp").forward(request,response);
    }
    response.sendRedirect(request.getContextPath()+"/AdminTypeServlet?method=findAllType");
    return null;
  }
  public String editTypeUI(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
    String id = request.getParameter("id");
    Type type = typeService.findTypeById(id);
    request.setAttribute("type",type);
    return "/admin/category/type/edit.jsp";
  }
  public String editType(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    Type type = new Type();
    type.setId(id);
    type.setName(name);
    try {
      typeService.editType(type);
    } catch (SQLException e) {
      e.printStackTrace();
      request.setAttribute("msg","修改失败");
      request.getRequestDispatcher("/admin/category/type/edit.jsp").forward(request,response);
    }
    response.sendRedirect(request.getContextPath()+"/AdminTypeServlet?method=findAllType");
    return null;
  }
}
