package com.backend.api.service;

import java.util.List;

import com.backend.api.model.PageDataCriteria;
import java.util.Map;

public interface  BasePageService<T , ID> {
     T save(T entity) throws Exception;    		
     void delete(long id) throws Exception;		
     List<T> getData(PageDataCriteria criteria) throws Exception;	
     List<T> getAllData() ; 
    List<T> search(Map<String, Object> param) ;
}
