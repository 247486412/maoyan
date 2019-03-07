package com.maoyan.service.serviceImpl;

import com.maoyan.dao.AreaDao;
import com.maoyan.entity.Area;
import com.maoyan.service.AreaService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class AreaServiceImpl implements AreaService {
  AreaDao areaDao = (AreaDao) BeanFactory.createObject("AreaDao");
  @Override
  public List<Area> findArea() throws SQLException {
	return areaDao.findArea();
  }

  @Override
  public Area findArea(String id) throws SQLException {
	return areaDao.findArea(id);
  }

  @Override
  public void addArea(Area area) throws SQLException {
	areaDao.addArea(area);
  }

  @Override
  public void editArea(Area area) throws SQLException {
	areaDao.editArea(area);
  }

  @Override
  public void deleteArea(String id) throws SQLException {
	areaDao.deleteArea(id);
  }
}
