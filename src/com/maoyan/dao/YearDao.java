package com.maoyan.dao;

import com.maoyan.entity.Year;

import java.sql.SQLException;
import java.util.List;

public interface YearDao {
  List<Year> findAllYear() throws SQLException;

  void addYear(Year year) throws SQLException;

  void deleteYear(String id) throws SQLException;

  Year findYearById(String id) throws SQLException;

  void editYear(Year year) throws SQLException;
}
