package com.backend.api.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.backend.api.annotation.JpaQualifier;
import com.backend.api.entity.BaseEntity;
import com.backend.api.model.ListOrder;
import com.backend.api.model.PageDataCriteria;
import com.backend.api.model.SqlParam;
import com.backend.api.service.BasePageService;
import com.backend.api.util.UtilSql;
import com.backend.api.util.pageFilter.IntegerHandler;
import com.backend.api.util.pageFilter.JsonDataHandler;
import com.backend.api.util.pageFilter.OrderHandler;
import com.backend.api.util.pageFilter.StringHandler;
import java.util.ArrayList;
import java.util.Map;

@Service
public abstract  class BasePageServiceImpl<T, ID>implements BasePageService<T, ID>{
    protected  ApplicationContext context;
    protected  JpaRepository<T, ID> baseRepository;
    protected  Object listEntity ; 
    public void setRepository(String qualifier) {
        this.baseRepository = (JpaRepository<T, ID>) this.context.getBean(qualifier);
    }
    protected void setListEntity(Object listEntity)
    {
        this.listEntity=listEntity ; 
    }
    
    protected void injectDependency(ApplicationContext context)
    {
        this.context = context ; 
        this.setRepository(this.getJpaQualifierValue());
    }
    
    protected String getJpaQualifierValue() {
        JpaQualifier annotation = this.getClass().getAnnotation(JpaQualifier.class);
        if (annotation != null) {
            return annotation.value();
        }
        return null ; 
    }
    
    public T save(T entity) throws Exception 
    {
        return this.baseRepository.save(entity) ; 
    }
    public void delete(ID id) throws Exception
    {
    	this.baseRepository.deleteById(id);
    }
    
    public List<T> getAllData()
    {
        return this.baseRepository.findAll();
    }
    
    public List<SqlParam> search(Map<String , Object> requestParam)
    {
        
        StringHandler stringHandler = new StringHandler() ; 
        IntegerHandler integerHandler = new  IntegerHandler(); 
        OrderHandler orderHandler = new OrderHandler() ; 
        stringHandler.setNext(integerHandler);
        integerHandler.setNext(orderHandler);
        List<SqlParam> sqlParamList = new ArrayList<SqlParam>() ; 
       
        PageDataCriteria pageDataCriteria = new PageDataCriteria();
        for (Map.Entry<String, Object> entry : requestParam.entrySet()) {            
            if(stringHandler.handleRequest(entry) instanceof SqlParam) 
            {
                sqlParamList.add((SqlParam) stringHandler.handleRequest(entry));
            }
            else if(stringHandler.handleRequest(entry) instanceof ListOrder) 
            {
                pageDataCriteria.setListOrder((ListOrder) stringHandler.handleRequest(entry));
            }    
        }
        pageDataCriteria.setSqlParamList(sqlParamList);        
        //UtilSql.convertJsonToSqlParamArray(requestParam) ; 
        return sqlParamList ; 
    }
}