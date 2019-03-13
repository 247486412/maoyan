package com.maoyan.service;

import com.maoyan.entity.Picture;

import java.sql.SQLException;
import java.util.List;

public interface PictureService {
  void addPicture(Picture fileEntity) throws SQLException;

  List<Picture> findPicture(String s) throws SQLException;

  void deleteAllPicture(String id) throws SQLException;

  void deletePicture(String id) throws SQLException;

  Picture download(String id) throws SQLException;
}
