package com.backend.api.model;

public final class Pagination {
    private int totalRowCount ; 
    private int maxElementByPage ; 
    private int totalPageNumber ; 
    private int currentPage ; 
    private int minPage ; 
    private int maxPage ; 
    private int minPageGap ; 
    private int maxPageGap ; 
    private int[] pageArray ;
    public int getTotalRowCount() {
        return totalRowCount;
    }
    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;
    }
    public int getMaxElementByPage() {
        return maxElementByPage;
    }
    public void setMaxElementByPage(int maxElementByPage) {
        this.maxElementByPage = maxElementByPage;
    }
    public int getTotalPageNumber() {
        return totalPageNumber;
    }
    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getMinPage() {
        return minPage;
    }
    public void setMinPage(int minPage) {
        this.minPage = minPage;
    }
    public int getMaxPage() {
        return maxPage;
    }
    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
    public int getMinPageGap() {
        return minPageGap;
    }
    public void setMinPageGap(int minPageGap) {
        this.minPageGap = minPageGap;
    }
    public int getMaxPageGap() {
        return maxPageGap;
    }
    public void setMaxPageGap(int maxPageGap) {
        this.maxPageGap = maxPageGap;
    }
    public int[] getPageArray() {
        return pageArray;
    }
    public void setPageArray(int[] pageArray) {
        this.pageArray = pageArray;
    } 
    
}
