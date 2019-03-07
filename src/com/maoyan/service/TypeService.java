package com.maoyan.service;

import com.maoyan.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeService {
  List<Type> findAllType() throws SQLException;

  void addType(Type type) throws SQLException;

  void deleteType(String id) throws SQLException;

  Type findTypeById(String id) throws SQLException;

  void editType(Type type) throws SQLException;
}
