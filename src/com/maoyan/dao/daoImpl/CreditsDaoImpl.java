package com.maoyan.dao.daoImpl;

import com.maoyan.dao.CreditsDao;
import com.maoyan.entity.Credits;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class CreditsDaoImpl implements CreditsDao {
  @Override
  public Credits findCredits(String id) throws SQLException {
    String sql = "select * from credits where id = ?";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	return queryRunner.query(sql, new BeanHandler<Credits>(Credits.class),id);
  }

  @Override
  public void deleteAll(String id) throws SQLException {
	String sql = "delete from credits where id = ?";
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	queryRunner.update(sql,id);
  }

  @Override
  public void deleteCredits(String id, String fieldName) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = " update credits set "+fieldName+" = null where id = ?";
	queryRunner.update(sql,id);
  }

  @Override
  public void addCredits(String id, String names, String type) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "update credits set "+type+"=? where id = ?";
	queryRunner.update(sql,names,id);
  }
}
