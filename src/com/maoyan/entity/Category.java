package com.maoyan.entity;

import java.util.List;

public class Category {
  private String id;
  private String name;
  private int disabled;
  private List<SecondCategory> secondCategoryList;

  public List<SecondCategory> getSecondCategoryList() {
    return secondCategoryList;
  }

  public void setSecondCategoryList(List<SecondCategory> secondCategoryList) {
    this.secondCategoryList = secondCategoryList;
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

  public int getDisabled() {
    return disabled;
  }

  public void setDisabled(int disabled) {
    this.disabled = disabled;
  }

  @Override
  public String toString() {
    return "Category{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", disabled=" + disabled +
            '}';
  }
}
