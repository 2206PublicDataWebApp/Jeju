package com.jeju.pagination.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pagination {
    private int currentPage;
    private int maxPage;
    private int startNavi;
    private int endNavi;
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the maxPage
	 */
	public int getMaxPage() {
		return maxPage;
	}
	/**
	 * @param maxPage the maxPage to set
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	/**
	 * @return the startNavi
	 */
	public int getStartNavi() {
		return startNavi;
	}
	/**
	 * @param startNavi the startNavi to set
	 */
	public void setStartNavi(int startNavi) {
		this.startNavi = startNavi;
	}
	/**
	 * @return the endNavi
	 */
	public int getEndNavi() {
		return endNavi;
	}
	/**
	 * @param endNavi the endNavi to set
	 */
	public void setEndNavi(int endNavi) {
		this.endNavi = endNavi;
	}
	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", maxPage=" + maxPage + ", startNavi=" + startNavi
				+ ", endNavi=" + endNavi + "]";
	}
    
    
}
