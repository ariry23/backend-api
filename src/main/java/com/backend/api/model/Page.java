package com.backend.api.model;

import java.util.List;

public class Page<T> {
    private List<T>	data; 
    private Pagination pagination;
    private boolean exportable;
    private PageDataCriteria pageCriteria ; 
    private boolean pageable ; 
    public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Pagination getPagination() {
        return pagination;
    }
	
    public boolean isExportable() {
		return exportable;
	}
	public void setExportable(boolean exportable) {
		this.exportable = exportable;
	}
	public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
	public PageDataCriteria getPageCriteria() {
		return pageCriteria;
	}
	public void setPageCriteria(PageDataCriteria pageCriteria) {	
		this.pageCriteria = pageCriteria;
	}
	public boolean isPageable() {
		return pageable;
	}
	public void setPageable(boolean pageable) {
		this.pageable = pageable;
	} 
	public void build()
	{
		this.pageable = this.pagination.getTotalPageNumber() > 1 ? true : false ; 
		this.exportable = this.data.size() > 0 ? true : false ; 
		if(this.pagination == null) 
			this.pagination = new Pagination();	
		this.pagination.setTotalRowCount(this.data.size()); 
		this.pagination.build();
	}
	
	
}
