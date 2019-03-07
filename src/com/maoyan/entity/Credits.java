package com.maoyan.entity;

public class Credits {
  private String id;
  private String director;
  private String actor;
  private String assistant_director;
  private String scriptwriter;
  private String producer;
  private String art_director;
  private String original_author;
  private String cameraman;
  private String executive_director;

  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

  public String getDirector() {
	return director;
  }

  public void setDirector(String director) {
	this.director = director;
  }

  public String getActor() {
	return actor;
  }

  public void setActor(String actor) {
	this.actor = actor;
  }

  public String getAssistant_director() {
	return assistant_director;
  }

  public void setAssistant_director(String assistant_director) {
	this.assistant_director = assistant_director;
  }

  public String getScriptwriter() {
	return scriptwriter;
  }

  public void setScriptwriter(String scriptwriter) {
	this.scriptwriter = scriptwriter;
  }

  public String getProducer() {
	return producer;
  }

  public void setProducer(String producer) {
	this.producer = producer;
  }

  public String getArt_director() {
	return art_director;
  }

  public void setArt_director(String art_director) {
	this.art_director = art_director;
  }

  public String getOriginal_author() {
	return original_author;
  }

  public void setOriginal_author(String original_author) {
	this.original_author = original_author;
  }

  public String getCameraman() {
	return cameraman;
  }

  public void setCameraman(String cameraman) {
	this.cameraman = cameraman;
  }

  public String getExecutive_director() {
	return executive_director;
  }

  public void setExecutive_director(String executive_director) {
	this.executive_director = executive_director;
  }

  @Override
  public String toString() {
	return "Credits{" +
			"id='" + id + '\'' +
			", director='" + director + '\'' +
			", actor='" + actor + '\'' +
			", assistant_director='" + assistant_director + '\'' +
			", scriptwriter='" + scriptwriter + '\'' +
			", producer='" + producer + '\'' +
			", art_director='" + art_director + '\'' +
			", original_author='" + original_author + '\'' +
			", cameraman='" + cameraman + '\'' +
			", executive_director='" + executive_director + '\'' +
			'}';
  }
}
