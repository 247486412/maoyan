package com.maoyan.entity;

import java.util.List;

//如果需要输出分页属性信息,需要调用get方法才行,因为计算是写在get方法下的
public class PagingBean<T> {
  private List<T> pageData;//当前页数据  通过开始下标和每页显示的数量从数据库查询
  private int firstPage=1;//第一页		   第一页默认为一
  private int prePage;//上一页		   如果上一页不是首页就当前页减一
  private int nextPage;//下一页          如果下一页不是尾页就当前页加一
  private int totalPage;//总页数或末页   总页数取余每页的记录数如果等于0，总页数就等于总页数除以每页的记录数(pageSize)，否则总页数加一
  private int currentPage;//当前页	   由页面传递过来
  private int totalCount;//总数据数量    需要去数据库查
  private int pageSize;//每页显示数量     每页显示多少条记录数
  private int startIndex;//开始下标      (为当前页数-1)*当前页的记录数
  private int startButton=1;//第一个按钮的数字
  private int lastButton;//最后一个按钮的数字
  private String url;//点击按钮通过url把参数带到后台

  public List<T> getPageData() {
	return pageData;
  }

  public void setPageData(List<T> pageData) {
	this.pageData = pageData;
  }

  public int getFirstPage() {
	return firstPage;
  }

  public void setFirstPage(int firstPage) {
	this.firstPage = firstPage;
  }

  //上一页：如果当前页是首页，则为首页，否则为当前页-1
  public int getPrePage() {
	return this.getCurrentPage() == this.getFirstPage() ? 1 : this.getCurrentPage() - 1;
  }

  public void setPrePage(int prePage) {
	this.prePage = prePage;
  }

  //下一页  如果当前页是末页，则为末页，否则为当前页+1
  public int getNextPage() {
	return this.getCurrentPage() == this.getTotalPage() ? getCurrentPage() : getCurrentPage() + 1;
  }

  public void setNextPage(int nextPage) {
	this.nextPage = nextPage;
  }

  //总页数 如果总记录数%每页显示记录数能够整除 ,则为总记录数/每页显示记录数，否则总记录数/每页显示记录数+1
  public int getTotalPage() {
	return this.getTotalCount() % this.getPageSize() == 0 ? this.getTotalCount() / this.getPageSize() : this.getTotalCount() / this.getPageSize() + 1;
  }

  public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
  }

  public int getCurrentPage() {
	return currentPage;
  }

  public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
  }

  public int getTotalCount() {
	return totalCount;
  }

  public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
  }

  public int getPageSize() {
	return pageSize;
  }

  public int getStartIndex() {
	return (this.getCurrentPage() - 1) * this.getPageSize();
  }

  public void setStartIndex(int startIndex) {
	this.startIndex = startIndex;
  }

  public void setPageSize(int pageSize) {
	this.pageSize = pageSize;

  }

  public int getLastButton() {
	return lastButton;
  }

  public void setLastButton(int lastButton) {
	this.lastButton = lastButton;
  }

  public int getStartButton() {
	return startButton;
  }

  public void setStartButton(int startButton) {
	this.startButton = startButton;
  }

  public String getUrl() {
	return url;
  }


  public void setUrl(String url) {
	this.url = url;
  }

  @Override
  public String toString() {
	return "PagingBean{" +
			"pageData=" + pageData +
			", firstPage=" + firstPage +
			", prePage=" + prePage +
			", nextPage=" + nextPage +
			", totalPage=" + totalPage +
			", currentPage=" + currentPage +
			", totalCount=" + totalCount +
			", pageSize=" + pageSize +
			'}';
  }

}
