package com.maoyan.service;

import java.sql.SQLException;
import java.util.Map;

public interface CreditsService {
  Map findCredits(String id) throws SQLException;

  void deleteAll(String id) throws SQLException;

  void deleteCredits(String id, String fieldName) throws SQLException;

  void addCredits(String id, String names, String type) throws SQLException;
}
