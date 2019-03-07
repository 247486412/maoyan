package com.maoyan.service.serviceImpl;

import com.maoyan.dao.CategoryDao;
import com.maoyan.entity.Category;
import com.maoyan.entity.SecondCategory;
import com.maoyan.service.CategoryService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
  CategoryDao categoryDao = (CategoryDao) BeanFactory.createObject("CategoryDao");
  @Override
  public List<Category> findAllCategory() throws SQLException {
	return categoryDao.findAllCategory();
  }

  @Override
  public void addCategory(Category category) throws SQLException {
	categoryDao.addCategory(category);
  }

  @Override
  public void deleteCategory(String id) throws SQLException {
	categoryDao.deleteCategory(id);
  }

  @Override
  public Category findCategoryById(String id) throws SQLException {
	return categoryDao.findCategoryById(id);
  }

  @Override
  public List<SecondCategory> findAllSecondCategory() throws SQLException {
	return categoryDao.findAllSecondCategory();
  }

  @Override
  public void editSecondCategory(SecondCategory secondCategory) throws SQLException {
	categoryDao.editSecondCategory(secondCategory);
  }

  @Override
  public SecondCategory findSecondCategoryById(String id) throws SQLException {
	return categoryDao.findSecondCategoryById(id);
  }

  @Override
  public void addSecondCategory(SecondCategory secondCategory) throws SQLException {
	categoryDao.addSecondCategory(secondCategory);
  }

  @Override
  public void deleteSecondCategory(String id) throws SQLException {
	categoryDao.deleteSecondCategory(id);
  }

  @Override
  public void editCategory(String id,String name) throws SQLException {
	categoryDao.editCategory(id,name);
  }
}
