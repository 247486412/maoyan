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
}
