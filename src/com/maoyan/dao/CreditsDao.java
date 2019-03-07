package com.maoyan.dao;

import com.maoyan.entity.Credits;

import java.sql.SQLException;
import java.util.List;

public interface CreditsDao {
  Credits findCredits(String id) throws SQLException;
}
