package com.maoyan.service.serviceImpl;

import com.maoyan.dao.PictureDao;
import com.maoyan.entity.Picture;
import com.maoyan.service.PictureService;
import com.maoyan.util.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class PictureServiceImpl implements PictureService {
  PictureDao pictureDao = (PictureDao) BeanFactory.createObject("PictureDao");
  @Override
  public void addPicture(Picture fileEntity) throws SQLException {
  pictureDao.addPicture(fileEntity);
  }


  @Override
  public Picture download(String id) throws SQLException {
    return pictureDao.download(id);
  }

  @Override
  public void deletePicture(String id) throws SQLException {
	pictureDao.deletePicture(id);
  }

  @Override
  public void deleteAllPicture(String id) throws SQLException {
    pictureDao.deleteAllPicture(id);
  }

  @Override
  public List<Picture> findPicture(String s) throws SQLException {
    return pictureDao.findPicture(s);
  }


}
