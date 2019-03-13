package com.maoyan.dao.daoImpl;

import com.maoyan.dao.MovieDao;
import com.maoyan.entity.Area;
import com.maoyan.entity.Credits;
import com.maoyan.entity.Movie;
import com.maoyan.entity.Picture;
import com.maoyan.entity.Type;
import com.maoyan.entity.Year;
import com.maoyan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
  @Override
  public List<Movie> findMovie(int start , int end) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "select * from movie where disable = 0 ORDER BY create_time DESC LIMIT ?,?";
	List<Movie> movieList = queryRunner.query(sql,new BeanListHandler<Movie>(Movie.class),start,end);

	for (Movie movie:movieList){
	  String areaId = movie.getArea_id();
	  String sql2 = "select * from area where id = ?";
	  Area area = queryRunner.query(sql2,new BeanHandler<Area>(Area.class),areaId);
	  movie.setArea(area);
	  String creditsId = movie.getCredits_id();
	  String sql3 = "select * from credits where id = ?";
	  Credits credits = queryRunner.query(sql3,new BeanHandler<Credits>(Credits.class),creditsId);
	  movie.setCredits(credits);
	  String pictureId = movie.getPicture_id();
	  String sql4 = "select * from picture where id = ?";
	  Picture picture = queryRunner.query(sql4,new BeanHandler<Picture>(Picture.class),pictureId);
	  movie.setPicture(picture);
	  String typeId= movie.getType_id();
	  String sql5 = "select * from type where id = ?";
	  Type type = queryRunner.query(sql5,new BeanHandler<Type>(Type.class),typeId);
	  movie.setType(type);
	  String yearId = movie.getYears_id();
	  String sql6 = "select * from year where id = ? ";
	  Year year = queryRunner.query(sql6,new BeanHandler<Year>(Year.class),yearId);
	  movie.setYear(year);
	}
	return movieList;
  }

  @Override
  public void deleteMovie(String id) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "update movie set disable = 1 where id = ?";
	queryRunner.update(sql,id);
  }


  @Override
  public void addMovie(Movie movie) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into movie values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	Object[] param = {movie.getId(),movie.getPicture_id(),movie.getName(),movie.getFlag(),movie.getDisable(),movie.getCredits_id(),movie.getType_id(),
	movie.getArea_id(),movie.getYears_id(),movie.getCreate_time(),movie.getScore(),movie.getComment(),movie.getDuration()};
	queryRunner.update(sql,param);
  }

  @Override
  public void addCredits(Credits credits) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into credits values(?,?,?,?,?,?,?,?,?,?)";
	Object[] param = {credits.getId(),credits.getDirector(),credits.getActor(),credits.getAssistant_director(),credits.getScriptwriter(),
	credits.getProducer(),credits.getArt_director(),credits.getOriginal_author(),credits.getCameraman(),credits.getExecutive_director()};
	queryRunner.update(sql,param);
  }


  @Override
  public int findTotalRecords() throws SQLException {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    String sql = "select count(*) from movie";
	Long count = (Long)queryRunner.query(sql,new ScalarHandler());
	return count.intValue();
  }

  @Override
  public void editMovie(Movie movie) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "update movie set type_id=? ,area_id = ?,duration=? ,years_id = ?,name = ? ,flag = ? where id = ?";
	Object[] param = {movie.getType_id(),movie.getArea_id(),movie.getDuration(),movie.getYears_id(),movie.getName(),movie.getFlag(),movie.getId()};
	queryRunner.update(sql,param);
  }


}
