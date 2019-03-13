package com.maoyan.entity;

public class Picture {
  private String id;
  private String name;
  private String path;
  private String size;
  private String movie_id;
  private String describe;

  public String getDescribe() {
	return describe;
  }

  public void setDescribe(String describe) {
	this.describe = describe;
  }

  public String getMovie_id() {
	return movie_id;
  }

  public void setMovie_id(String movie_id) {
	this.movie_id = movie_id;
  }

  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getPath() {
	return path;
  }

  public void setPath(String path) {
	this.path = path;
  }

  public String getSize() {
	return size;
  }

  public void setSize(String size) {
	this.size = size;
  }

  @Override
  public String toString() {
	return "Picture{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", path='" + path + '\'' +
			", size='" + size + '\'' +
			", movie_id='" + movie_id + '\'' +
			", describe='" + describe + '\'' +
			'}';
  }
}
