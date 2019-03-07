package com.maoyan.dao.daoImpl;

import com.maoyan.dao.TypeDao;
import com.maoyan.entity.Type;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
  @Override
  public Type findTypeById(String id) throws SQLException {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    String sql = "select * from type where id = ?";
	return queryRunner.query(sql,new BeanHandler<Type>(Type.class),id);
  }

  @Override
  public void editType(Type type) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "update type set name = ? where id = ?";
	queryRunner.update(sql,type.getName(),type.getId());
  }

  @Override
  public void deleteType(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql  =" delete from type where id = ?";
	queryRunner.update(sql,id);
  }

  @Override
  public void addType(Type type) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into type values (?,?)";
	queryRunner.update(sql,type.getId(),type.getName());
  }

  @Override
  public List<Type> findAllType() throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "select * from type";
	return queryRunner.query(sql,new BeanListHandler<Type>(Type.class));
  }
}
