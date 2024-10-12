package com.backend.api.service;

import java.util.List;

import com.backend.api.model.PageDataCriteria;

public interface  BasePageService<T , ID> {
     T save(T entity) throws Exception;    		
     void delete(long id) throws Exception;		
     List<T> getData(PageDataCriteria criteria) throws Exception;		
}
