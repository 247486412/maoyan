package com.maoyan.entity;

public class SecondCategory {
  private String id;
  private String name;
  private String category_id;
  private int disabled;
  private Category category;

  public Category getCategory() {
	return category;
  }

  public void setCategory(Category category) {
	this.category = category;
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

  public String getCategory_id() {
	return category_id;
  }

  public void setCategory_id(String category_id) {
	this.category_id = category_id;
  }

  public int getDisabled() {
	return disabled;
  }

  public void setDisabled(int disabled) {
	this.disabled = disabled;
  }

  @Override
  public String toString() {
	return "SecondCategory{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", category_id='" + category_id + '\'' +
			", disabled=" + disabled +
			", category=" + category +
			'}';
  }
}
