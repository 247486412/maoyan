package com.maoyan.entity;

public class Area {
  private String id;
  private String name;

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


  @Override
  public String toString() {
	return "AreaDao{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			'}';
  }
}
