package com.maoyan.dao;

import com.maoyan.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDao {
  List<Type> findAllType() throws SQLException;

  void addType(Type type) throws SQLException;

  void deleteType(String id) throws SQLException;

  Type findTypeById(String id) throws SQLException;

  void editType(Type type) throws SQLException;
}
