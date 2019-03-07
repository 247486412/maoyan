package com.maoyan.service;

import com.maoyan.entity.Credits;

import java.sql.SQLException;
import java.util.List;

public interface CreditsService {
  Credits findCredits(String id) throws SQLException;
}
