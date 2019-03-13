package com.maoyan.entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {
  private String id;
  private String name;
  private String  picture_id;
  private Picture picture;
  private List<Picture> pictureList = new ArrayList<Picture>();
  private int flag;
  private int disable;
  private String type_id;
  private Type type;
  private List<Type> typeList = new ArrayList<Type>();
  private String area_id;
  private Area area;
  private String years_id;
  private Year year;
  private String credits_id;
  private Credits credits;
  private String create_time;
  private double score;
  private String comment;
  private String duration;

  public Picture getPicture() {
	return picture;
  }

  public void setPicture(Picture picture) {
	this.picture = picture;
  }

  public List<Picture> getPictureList() {
	return pictureList;
  }

  public void setPictureList(List<Picture> pictureList) {
	this.pictureList = pictureList;
  }

  public Type getType() {
	return type;
  }

  public void setType(Type type) {
	this.type = type;
  }

  public List<Type> getTypeList() {
	return typeList;
  }

  public void setTypeList(List<Type> typeList) {
	this.typeList = typeList;
  }

  public Area getArea() {
	return area;
  }

  public void setArea(Area area) {
	this.area = area;
  }

  public Year getYear() {
	return year;
  }

  public void setYear(Year year) {
	this.year = year;
  }

  public Credits getCredits() {
	return credits;
  }

  public void setCredits(Credits credits) {
	this.credits = credits;
  }

  public String getDuration() {
	return duration;
  }

  public void setDuration(String duration) {
	this.duration = duration;
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

  public double getScore() {
	return score;
  }

  public void setScore(double score) {
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
			", picture=" + picture +
			", pictureList=" + pictureList +
			", flag=" + flag +
			", disable=" + disable +
			", type_id='" + type_id + '\'' +
			", type=" + type +
			", typeList=" + typeList +
			", area_id='" + area_id + '\'' +
			", area=" + area +
			", years_id='" + years_id + '\'' +
			", year=" + year +
			", credits_id='" + credits_id + '\'' +
			", credits=" + credits +
			", create_time='" + create_time + '\'' +
			", score=" + score +
			", comment='" + comment + '\'' +
			", duration='" + duration + '\'' +
			'}';
  }
}
