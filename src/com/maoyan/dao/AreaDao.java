package com.maoyan.dao;

import com.maoyan.entity.Area;

import java.sql.SQLException;
import java.util.List;

public interface AreaDao {
  List<Area> findArea() throws SQLException;

  Area findArea(String id ) throws SQLException;

  void addArea(Area area) throws SQLException;

  void editArea(Area area) throws SQLException;

  void deleteArea(String id) throws SQLException;
}
