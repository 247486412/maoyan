package com.maoyan.web.servlet;

import com.maoyan.entity.Category;
import com.maoyan.entity.SecondCategory;
import com.maoyan.service.CategoryService;
import com.maoyan.service.serviceImpl.CategoryServiceImpl;
import com.maoyan.util.UUIDUtils;
import com.maoyan.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet", urlPatterns = "/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
  private CategoryService categoryService = new CategoryServiceImpl();

  public String findAllCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	List<Category> categoryList = categoryService.findAllCategory();
	request.setAttribute("categoryList", categoryList);
	return "/admin/category/list.jsp";
  }

  public String addCategoryUI(HttpServletRequest request, HttpServletResponse response) {
	return "/admin/category/add.jsp";
  }

  public String addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String[] categoryName = request.getParameterValues("name");
	for (String name : categoryName) {
	  Category category = new Category();
	  category.setId(UUIDUtils.getId());
	  category.setName(name);
	  try {
		categoryService.addCategory(category);
	  } catch (SQLException e) {
		request.setAttribute("msg", "添加失败");
		request.getRequestDispatcher("/admin/category/add.jsp").forward(request, response);
		e.printStackTrace();
	  }
	  response.sendRedirect(request.getContextPath() + "/AdminCategoryServlet?method=findAllCategory");
	}
	return null;
  }

  public String deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String id = request.getParameter("id");
	try {
	  categoryService.deleteCategory(id);
	} catch (SQLException e) {
	  request.setAttribute("msg", "删除失败");
	  request.getRequestDispatcher("/admin/category/list.jsp").forward(request, response);
	  e.printStackTrace();
	}
	response.sendRedirect(request.getContextPath() + "/AdminCategoryServlet?method=findAllCategory");
	return null;
  }

  public String editCategoryUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	String id = request.getParameter("id");
	Category category = categoryService.findCategoryById(id);
	request.setAttribute("category", category);
	return "/admin/category/edit.jsp";
  }

  public String editCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	String id = request.getParameter("id");
	String categoryName = request.getParameter("categoryName");
	categoryService.editCategory(id, categoryName);
	response.sendRedirect(request.getContextPath() + "/AdminCategoryServlet?method=findAllCategory");
	return null;
  }

  public String findAllSecondCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	List<SecondCategory> categoryList = categoryService.findAllSecondCategory();
	request.setAttribute("categoryList", categoryList);
	return "admin/category/secondCategory/list.jsp";
  }

  public String deleteSecondCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String id = request.getParameter("id");
	try {
	  categoryService.deleteSecondCategory(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "删除该分类失败");
	  request.getRequestDispatcher("/admin/category/secondCategory/list.jsp").forward(request, response);
	}
	response.sendRedirect(request.getContextPath() + "/AdminCategoryServlet?method=findAllSecondCategory");
	return null;
  }

  public String addSecondCategoryUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	List<Category> categoryList = categoryService.findAllCategory();
	request.setAttribute("categoryList", categoryList);
	return "/admin/category/secondCategory/add.jsp";
  }

  public String addSecondCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String categoryId = request.getParameter("belongCategory");
	String categoryName = request.getParameter("name");
	SecondCategory secondCategory = new SecondCategory();
	secondCategory.setId(UUIDUtils.getId());
	secondCategory.setName(categoryName);
	secondCategory.setCategory_id(categoryId);
	try {
	  categoryService.addSecondCategory(secondCategory);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "添加失败");
	  request.getRequestDispatcher("/admin/category/secondCategory/add.jsp").forward(request, response);
	}
	response.sendRedirect(request.getContextPath() + "/AdminCategoryServlet?method=findAllSecondCategory");
	return null;
  }

  public String editSecondCategoryUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	String id = request.getParameter("id");
	List<Category> categoryList = categoryService.findAllCategory();
	SecondCategory secondCategory = categoryService.findSecondCategoryById(id);
	request.setAttribute("categoryList", categoryList);
	request.setAttribute("secondCategory", secondCategory);
	return "/admin/category/secondCategory/edit.jsp";
  }

  public String editSecondCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String id = request.getParameter("id");
	String name = request.getParameter("categoryName");
	String categoryId = request.getParameter("categoryId");
	SecondCategory secondCategory = new SecondCategory();
	secondCategory.setId(id);
	secondCategory.setName(name);
	secondCategory.setCategory_id(categoryId);
	try {
	  categoryService.editSecondCategory(secondCategory);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "添加失败");
	  request.getRequestDispatcher("/admin/category/secondCategory/edit.jsp").forward(request, response);
	}
	response.sendRedirect(request.getContextPath() + "/AdminCategoryServlet?method=findAllSecondCategory");
	return null;
  }

}
