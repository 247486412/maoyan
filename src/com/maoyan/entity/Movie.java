package com.maoyan.entity;

public class Movie {
  private String id;
  private String name;
  private String  picture_id;
  private int flag;
  private int disable;
  private String type_id;
  private String area_id;
  private String years_id;
  private String credits_id;
  private String create_time;
  private int score;
  private String comment;

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

  public String getPicture_id() {
	return picture_id;
  }

  public void setPicture_id(String picture_id) {
	this.picture_id = picture_id;
  }

  public int getFlag() {
	return flag;
  }

  public void setFlag(int flag) {
	this.flag = flag;
  }

  public int getDisable() {
	return disable;
  }

  public void setDisable(int disable) {
	this.disable = disable;
  }

  public String getType_id() {
	return type_id;
  }

  public void setType_id(String type_id) {
	this.type_id = type_id;
  }

  public String getArea_id() {
	return area_id;
  }

  public void setArea_id(String area_id) {
	this.area_id = area_id;
  }

  public String getYears_id() {
	return years_id;
  }

  public void setYears_id(String years_id) {
	this.years_id = years_id;
  }

  public String getCredits_id() {
	return credits_id;
  }

  public void setCredits_id(String credits_id) {
	this.credits_id = credits_id;
  }

  public String getCreate_time() {
	return create_time;
  }

  public void setCreate_time(String create_time) {
	this.create_time = create_time;
  }

  public int getScore() {
	return score;
  }

  public void setScore(int score) {
	this.score = score;
  }

  public String getComment() {
	return comment;
  }

  public void setComment(String comment) {
	this.comment = comment;
  }

  @Override
  public String toString() {
	return "Movie{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", picture_id='" + picture_id + '\'' +
			", flag=" + flag +
			", disable=" + disable +
			", type_id='" + type_id + '\'' +
			", area_id='" + area_id + '\'' +
			", years_id='" + years_id + '\'' +
			", credits_id='" + credits_id + '\'' +
			", create_time='" + create_time + '\'' +
			", score=" + score +
			", comment='" + comment + '\'' +
			'}';
  }
}
