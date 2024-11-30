package com.backend.api.service;

import java.util.List;

import com.backend.api.model.PageDataCriteria;
import com.backend.api.model.SqlParam;
import java.util.Map;

public interface  BasePageService<T , ID> {
    T save(T entity) throws Exception;    		
    void delete(long id) throws Exception;		
    List<T> getData(PageDataCriteria criteria) throws Exception;	
    List<T> getAllData() ; 
    List<SqlParam> search(Map<String, Object> param) ;
}
