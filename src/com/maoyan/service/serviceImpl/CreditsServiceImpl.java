package com.maoyan.service.serviceImpl;

import com.maoyan.dao.CreditsDao;
import com.maoyan.entity.Credits;
import com.maoyan.service.CreditsService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CreditsServiceImpl implements CreditsService {
  private CreditsDao creditsDao = (CreditsDao) BeanFactory.createObject("CreditsDao");

  @Override
  public Credits findCredits(String id) throws SQLException {
	Credits credits = creditsDao.findCredits(id);
	Map<String ,String> creditsMap = new HashMap<String ,String>();
	creditsMap.put(credits.getActor(),"演员");
	return null;
  }
}
