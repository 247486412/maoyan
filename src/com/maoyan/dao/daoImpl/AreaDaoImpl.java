package com.maoyan.dao.daoImpl;

import com.maoyan.dao.AreaDao;
import com.maoyan.entity.Area;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AreaDaoImpl implements AreaDao {
  @Override
  public Area findArea(String id) throws SQLException {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    String sql = "select * from area where id = ?";
	return queryRunner.query(sql,new BeanHandler<>(Area.class),id);
  }

  @Override
  public List<Area> findArea() throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "select * from area";
	return queryRunner.query(sql,new BeanListHandler<Area>(Area.class));
  }

  @Override
  public void addArea(Area area) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into area values(?,?)";
	queryRunner.update(sql,area.getId(),area.getName());
  }

  @Override
  public void editArea(Area area) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "update area set name = ? where id = ?";
	queryRunner.update(sql,area.getName(),area.getId());
  }

  @Override
  public void deleteArea(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "delete from area where id = ?";
	queryRunner.update(sql,id);
  }
}
