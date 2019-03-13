package com.maoyan.dao.daoImpl;
import com.maoyan.dao.PictureDao;
import com.maoyan.entity.Picture;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PictureDaoImpl implements PictureDao {
  @Override
  public void addPicture(Picture fileEntity) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into picture values(?,?,?,?,?,?)";
	Object[] param = {fileEntity.getId(),fileEntity.getName(),fileEntity.getPath(),fileEntity.getSize(),fileEntity.getMovie_id(),fileEntity.getDescribe()};
	queryRunner.update(sql,param);
  }

  @Override
  public List<Picture> findPicture(String s) throws SQLException {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    String sql = "select * from picture where movie_id=?";
	return queryRunner.query(sql,new BeanListHandler<Picture>(Picture.class),s);
  }

  @Override
  public void deleteAllPicture(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql ="delete from picture where movie_id =?";
	queryRunner.update(sql,id);
  }

  @Override
  public Picture download(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "select * from picture where id = ?";
	return queryRunner.query(sql,new BeanHandler<Picture>(Picture.class),id);
  }


  @Override
  public void deletePicture(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "delete from picture where id = ?";
	queryRunner.update(sql,id);
  }
}
