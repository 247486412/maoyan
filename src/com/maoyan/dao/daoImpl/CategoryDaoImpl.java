package com.maoyan.dao.daoImpl;

import com.maoyan.dao.CategoryDao;
import com.maoyan.entity.Category;
import com.maoyan.entity.SecondCategory;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
  @Override
  public void deleteSecondCategory(String id) throws SQLException {
	String sql = "update second_category set disabled=1 where id = ?";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	queryRunner.update(sql, id);
  }

  @Override
  public List<Category> findAllCategory() throws SQLException {
	String sql = "select * from category where disabled = 0";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	return queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
  }

  @Override
  public void addCategory(Category category) throws SQLException {
	String sql = "insert into category values(?,?,?)";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	queryRunner.update(sql, category.getId(), category.getName(), category.getDisabled());
  }

  @Override
  public void deleteCategory(String id) throws SQLException {
	String sql = "update category set disabled = 1 where id= ? ";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	queryRunner.update(sql, id);
  }

  @Override
  public Category findCategoryById(String id) throws SQLException {
	String sql = "select * from category where id = ? and disabled =0";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	return queryRunner.query(sql, new BeanHandler<>(Category.class), id);
  }

  @Override
  public List<SecondCategory> findAllSecondCategory() throws SQLException {
	String sql = "select * from second_category where disabled = 0";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	List<SecondCategory> list = queryRunner.query(sql, new BeanListHandler<SecondCategory>(SecondCategory.class));
	for (SecondCategory second : list) {
	  String categoryId = second.getCategory_id();
	  sql = "select * from category where id = ?";
	  List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class), categoryId);
	  for (Category category : categoryList) {
		second.setCategory(category);
	  }
	}
	return list;
  }

  @Override
  public void editCategory(String id, String name) throws SQLException {
	String sql = "update category set name = ? where id = ?";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	queryRunner.update(sql, name, id);
  }

  @Override
  public void addSecondCategory(SecondCategory secondCategory) throws SQLException {
	String sql = "insert into second_category values(?,?,?,?)";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	queryRunner.update(sql, secondCategory.getId(), secondCategory.getCategory_id(), secondCategory.getName(), secondCategory.getDisabled());
  }

  @Override
  public SecondCategory findSecondCategoryById(String id) throws SQLException {
	String sql = "select * from second_category where id = ?";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	return queryRunner.query(sql, new BeanHandler<SecondCategory>(SecondCategory.class), id);
  }

  @Override
  public void editSecondCategory(SecondCategory secondCategory) throws SQLException {
  String sql = "update second_category set name=? , category_id = ? where id= ?";
  QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
  queryRunner.update(sql,secondCategory.getName(),secondCategory.getCategory_id(),secondCategory.getId());
  }


}
