package com.backend.api.model;

import com.backend.api.constant.PaginationConstant;

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
    
    private  void diplayPagination() {
        if(this.currentPage > this.minPageGap)
        {
            if(this.currentPage + this.maxPageGap <= this.totalPageNumber)
            {
                this.minPage = this.currentPage - this.minPageGap ; 
                this.maxPage = this.currentPage + this.maxPageGap ; 
            }
            else
            {
                this.maxPage = this.totalPageNumber ; 
                this.minPage = this.maxPage - (this.minPageGap + this.maxPageGap) > 0 ? this.maxPage - (this.minPageGap + this.maxPageGap) : 1 ; 
            }
        }
        else{
            this.minPage = 1 ; 
            if(this.totalPageNumber >= this.currentPage + this.maxPageGap )
            {
                this.maxPage = this.currentPage + this.maxPageGap ; 
            }
            else{
                this.maxPage = this.totalPageNumber ; 
            }
        }
        int page = this.minPage ; 
        int x = this.totalPageNumber > this.minPageGap + this.maxPageGap + 1 ? this.minPageGap + this.maxPageGap + 1 :  this.totalPageNumber; 
        for(int i = 0 ; i < x ; i ++ )
        {
            this.pageArray[i] = page ; 
            page ++ ;
        }
    }
            
    public void build()
    {
        if(this.totalRowCount > 0) 
        {
            int pageArraySize = 1 ; 
            if(this.totalRowCount > this.maxElementByPage)
            {
                this.totalPageNumber = this.totalRowCount / this.maxElementByPage ; 
                if(this.totalRowCount % this.maxElementByPage > 0 )
                {
                    this.totalPageNumber ++ ; 
                }
                if(this.totalPageNumber > this.minPageGap + this.maxPageGap + 1){
                    pageArraySize = this.minPageGap + this.maxPageGap + 1 ; 
                }
                if(this.totalPageNumber <= this.minPageGap + this.maxPageGap + 1)
                {
                    pageArraySize = this.totalPageNumber ; 
                }
            } 
            else{
                this.totalPageNumber = 1 ;
            }
            
            this.pageArray = new int[pageArraySize] ; 
            this.diplayPagination() ; 
        }
        
    }
    
    public Pagination()
    {
    	this.maxPageGap = PaginationConstant.MAX_PAGE_GAP ; 
        this.minPageGap = PaginationConstant.MIN_PAGE_GAP ; 
        this.currentPage = 1 ; 
        this.maxElementByPage = PaginationConstant.MAX_ELEMENT_BY_PAGE ; 
    }
}
