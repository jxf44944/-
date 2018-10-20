package com.util;

import java.util.List;

public class PageBean {
	@SuppressWarnings("unchecked")
	private List list;   //要返回的某一页的记录列表
	private int allRow;  //总记录数
	private int totalPage;  //总页数
	private int currentPage;  //当前页
	private int pageSize; //每页记录数

	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
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
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 计算总页数,静态方法,供外部直接通过类名调用
	 * @param pageSize  每页记录数
	 * @param allRow  总记录数
	 * @return  总页数
　　 */
	public static int countTotalPage(final int pageSize,final int allRow){
		int totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
		return totalPage;
	}
	/**
	 * 计算当前页开始记录
	 * @param pageSize  每页记录数
	 * @param currentPage  当前第几页
	 * @return 当前页开始记录号
	 */
	public static int countOffset(final int pageSize,final int currentPage){
		final int offset = pageSize * (currentPage-1);
		return offset;
	}
	/**
	 * 计算当前页,若为0或者请求的URL中没有"?page=",则用1代替
	 * @param page  传入的参数(可能为空,即0,则返回1)
	 * @return  当前页
	 */
	public static int countCurrentPage(int page){
		final int curPage = (page==0?1:page);
		return curPage;
	}
}