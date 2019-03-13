package com.maoyan.dao;

import com.maoyan.entity.Credits;
import com.maoyan.entity.Movie;
import com.maoyan.entity.Picture;

import java.sql.SQLException;
import java.util.List;

public interface MovieDao {
  List<Movie> findMovie(int start , int end) throws SQLException;

  void deleteMovie(String id) throws SQLException;

  void addMovie(Movie movie) throws SQLException;

  void addCredits(Credits credits) throws SQLException;

  void editMovie(Movie movie) throws SQLException;

  int findTotalRecords() throws SQLException;
}
