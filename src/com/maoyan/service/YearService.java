package com.maoyan.service;

import com.maoyan.entity.Year;

import java.sql.SQLException;
import java.util.List;

public interface YearService {
  List<Year> findYear() throws SQLException;

  Year findYear(String id) throws SQLException;

  void addYear(Year year) throws SQLException;

  void deleteYear(String id) throws SQLException;

  void editYear(Year year) throws SQLException;
}
