package com.maoyan.service.serviceImpl;

import com.maoyan.dao.CreditsDao;
import com.maoyan.entity.Credits;
import com.maoyan.service.CreditsService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreditsServiceImpl implements CreditsService {
  private CreditsDao creditsDao = (CreditsDao) BeanFactory.createObject("CreditsDao");

  @Override
  public Map<String ,Map<String,String>> findCredits(String id) throws SQLException {
	Credits credits = creditsDao.findCredits(id);
	if(credits==null||credits.getId()==null){
	  return null;
	}else {
	  Map<String ,Map<String,String>> creditsMap = new LinkedHashMap<String ,Map<String,String>>();

	  Map<String,String> idMap = new HashMap<String,String>();
	  idMap.put("id",credits.getId());
	  creditsMap.put("id",idMap);

	  Map<String,String> actorMap = new HashMap<String,String>();
	  actorMap.put("演员",credits.getActor());
	  creditsMap.put("actor",actorMap);

	  Map<String,String> directorMap = new HashMap<String,String>();
	  directorMap.put("导演",credits.getDirector());
	  creditsMap.put("director",directorMap);

	  Map<String,String> assistant_directorMap = new HashMap<String,String>();
	  assistant_directorMap.put("副导演",credits.getAssistant_director());
	  creditsMap.put("assistant_director",assistant_directorMap);

	  Map<String,String> executive_directorMap = new HashMap<String,String>();
	  executive_directorMap.put("执行导演",credits.getExecutive_director());
	  creditsMap.put("executive_director",executive_directorMap);

	  Map<String,String> producerMap = new HashMap<String,String>();
	  producerMap.put("制片人",credits.getProducer());
	  creditsMap.put("producer",producerMap);

	  Map<String,String> scriptwriterMap = new HashMap<String,String>();
	  scriptwriterMap.put("编剧",credits.getScriptwriter());
	  creditsMap.put("scriptwriter",scriptwriterMap);

	  Map<String,String> cameramanMap = new HashMap<String,String>();
	  cameramanMap.put("摄影师",credits.getCameraman());
	  creditsMap.put("cameraman",cameramanMap);

	  Map<String,String> art_directorMap = new HashMap<String,String>();
	  art_directorMap.put("艺术指导",credits.getArt_director());
	  creditsMap.put("art_director",art_directorMap);

	  Map<String,String> original_authorMap = new HashMap<String,String>();
	  original_authorMap.put("原作者",credits.getOriginal_author());
	  creditsMap.put("original_author",original_authorMap);
	  return creditsMap;
	}

  }

  @Override
  public void deleteAll(String id) throws SQLException {
	creditsDao.deleteAll(id);
  }

  @Override
  public void addCredits(String id, String names, String type) throws SQLException {
creditsDao.addCredits(id,names,type);
  }

  @Override
  public void deleteCredits(String id, String fieldName) throws SQLException {
	creditsDao.deleteCredits(id,fieldName);
  }
}
