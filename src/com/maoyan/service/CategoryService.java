package com.maoyan.service;

import com.maoyan.entity.Category;
import com.maoyan.entity.SecondCategory;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
  List<Category> findAllCategory() throws SQLException;

  void addCategory(Category category) throws SQLException;

  void deleteCategory(String id) throws SQLException;

  Category findCategoryById(String id) throws SQLException;

  void editCategory(String id,String name) throws SQLException;

  List<SecondCategory> findAllSecondCategory() throws SQLException;

  void deleteSecondCategory(String id) throws SQLException;

  void addSecondCategory(SecondCategory secondCategory) throws SQLException;

  SecondCategory findSecondCategoryById(String id) throws SQLException;

  void editSecondCategory(SecondCategory secondCategory) throws SQLException;
}
