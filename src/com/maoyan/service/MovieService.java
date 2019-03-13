package com.maoyan.service;

import com.maoyan.entity.Credits;
import com.maoyan.entity.Movie;
import com.maoyan.entity.PagingBean;
import com.maoyan.entity.Picture;

import java.sql.SQLException;
import java.util.List;

public interface MovieService {
  PagingBean<Movie> findMovie(int current) throws SQLException;

  void deleteMovie(String id) throws SQLException;

  void addMovie(Movie movie) throws SQLException;

  void editMovie(Movie movie) throws SQLException;
}
