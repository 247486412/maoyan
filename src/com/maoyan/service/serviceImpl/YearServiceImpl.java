package com.maoyan.service.serviceImpl;

import com.maoyan.dao.YearDao;
import com.maoyan.entity.Year;
import com.maoyan.service.YearService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class YearServiceImpl implements YearService {
  private YearDao yearDao = (YearDao) BeanFactory.createObject("YearDao");

  @Override
  public List<Year> findYear() throws SQLException {
	return yearDao.findAllYear();
  }

  @Override
  public Year findYear(String id) throws SQLException {
	return yearDao.findYearById(id);
  }

  @Override
  public void addYear(Year year) throws SQLException {
	yearDao.addYear(year);
  }

  @Override
  public void deleteYear(String id) throws SQLException {
	yearDao.deleteYear(id);
  }

  @Override
  public void editYear(Year year) throws SQLException {
	yearDao.editYear(year);
  }
}
