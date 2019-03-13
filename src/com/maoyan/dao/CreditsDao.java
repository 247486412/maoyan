package com.maoyan.dao;

import com.maoyan.entity.Credits;

import java.sql.SQLException;
import java.util.List;

public interface CreditsDao {
  Credits findCredits(String id) throws SQLException;

  void deleteAll(String id) throws SQLException;

  void deleteCredits(String id, String fieldName) throws SQLException;

  void addCredits(String id, String names, String type) throws SQLException;
}
