package com.maoyan.service.serviceImpl;

import com.maoyan.dao.MovieDao;
import com.maoyan.dao.PictureDao;
import com.maoyan.dao.daoImpl.PictureDaoImpl;
import com.maoyan.entity.Credits;
import com.maoyan.entity.Movie;
import com.maoyan.entity.PagingBean;
import com.maoyan.entity.Picture;
import com.maoyan.service.MovieService;
import com.maoyan.service.PictureService;
import com.maoyan.util.BeanFactory;
import com.maoyan.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MovieServiceImpl implements MovieService {
  private MovieDao movieDao = (MovieDao) BeanFactory.createObject("MovieDao");

  @Override
  public PagingBean<Movie> findMovie(int currentPage) throws SQLException {
	int totalRecords = movieDao.findTotalRecords();
	PagingBean<Movie> page = new PagingBean<Movie>();
	page.setPageSize(7);
	page.setTotalCount(totalRecords);
	page.setUrl("/AdminMovieServlet?method=findMovie");
	page.setCurrentPage(currentPage);
	if (page.getCurrentPage() > 2) {
	  page.setStartButton(page.getCurrentPage() - 2);
	}

	if(page.getTotalPage()>page.getLastButton()){
	  page.setLastButton(page.getStartButton() + 4);
	}

	List<Movie> list = movieDao.findMovie(page.getStartIndex(), page.getPageSize());
	page.setPageData(list);
	return page;
  }

  @Override
  public void deleteMovie(String id) throws SQLException {
	movieDao.deleteMovie(id);
  }


  @Override
  public void editMovie(Movie movie) throws SQLException {
	movieDao.editMovie(movie);
  }

  @Override
  public void addMovie(Movie movie) throws SQLException {
	Connection con = null;
	try {
	  con = JDBCUtils.getConnection();
	  con.setAutoCommit(false);
	  Picture picture = movie.getPicture();
	  PictureService pictureService = new PictureServiceImpl();
	  pictureService.addPicture(picture);
	  movieDao.addCredits(movie.getCredits());
	  movieDao.addMovie(movie);
	} catch (SQLException e) {
	  e.printStackTrace();
	  con.rollback();
	}
  }

}
