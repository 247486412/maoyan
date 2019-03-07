package com.maoyan.service.serviceImpl;

import com.maoyan.dao.TypeDao;
import com.maoyan.entity.Type;
import com.maoyan.service.TypeService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl implements TypeService {
  TypeDao typeDao = (TypeDao) BeanFactory.createObject("TypeDao");

  @Override
  public List<Type> findAllType() throws SQLException {
	return typeDao.findAllType();
  }

  @Override
  public Type findTypeById(String id) throws SQLException {
	return typeDao.findTypeById(id);
  }

  @Override
  public void editType(Type type) throws SQLException  {
	typeDao.editType(type);
  }

  @Override
  public void deleteType(String id) throws SQLException {
	typeDao.deleteType(id);
  }

  @Override
  public void addType(Type type) throws SQLException {
	typeDao.addType(type);
  }
}
