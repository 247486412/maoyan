package com.maoyan.dao.daoImpl;

import com.maoyan.dao.YearDao;
import com.maoyan.entity.Year;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class YearDaoImpl implements YearDao {
  @Override
  public List<Year> findAllYear() throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "select * from year";
	return queryRunner.query(sql,new BeanListHandler<Year>(Year.class));
  }

  @Override
  public void addYear(Year year) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into year values(?,?)";
	queryRunner.update(sql,year.getId(),year.getName());
  }

  @Override
  public void deleteYear(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "delete from year where id= ?";
	queryRunner.update(sql,id);
  }

  @Override
  public Year findYearById(String id) throws SQLException {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    String sql = "select * from year where id = ?";
	return queryRunner.query(sql,new BeanHandler<Year>(Year.class),id);
  }

  @Override
  public void editYear(Year year) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "update year set name = ? where id = ?";
	queryRunner.update(sql,year.getName(),year.getId());
  }
}
