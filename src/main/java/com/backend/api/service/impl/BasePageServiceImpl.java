package com.backend.api.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.backend.api.annotation.JpaQualifier;
import com.backend.api.entity.BaseEntity;
import com.backend.api.model.PageDataCriteria;
import com.backend.api.service.BasePageService;
import com.backend.api.util.UtilSql;
import java.util.Map;

@Service
public abstract  class BasePageServiceImpl<T, ID>implements BasePageService<T, ID>{
    protected  ApplicationContext context;
    protected  JpaRepository<T, ID> baseRepository;
    
    public void setRepository(String qualifier) {
        this.baseRepository = (JpaRepository<T, ID>) this.context.getBean(qualifier);
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
    
    public List<T> search(Map<String , Object> requestParam)
    {
        UtilSql.convertJsonToSqlParamArray(requestParam) ; 
        return null ; 
    }
}