package com.maoyan.dao;

import com.maoyan.entity.Picture;

import java.sql.SQLException;
import java.util.List;

public interface PictureDao {
  void addPicture(Picture fileEntity) throws SQLException;

  List<Picture> findPicture(String s) throws SQLException;

  void deleteAllPicture(String id) throws SQLException;

  void deletePicture(String id) throws SQLException;

  Picture download(String id) throws SQLException;
}
