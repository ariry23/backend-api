package com.backend.api.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.backend.api.annotation.JpaQualifier;
import com.backend.api.entity.BaseEntity;
import com.backend.api.model.PageDataCriteria;
import com.backend.api.service.BasePageService;

@Service
public abstract  class BasePageServiceImpl<T extends BaseEntity, ID>implements BasePageService<T, ID>{
    private final ApplicationContext context;
    private  JpaRepository<T, ID> baseRepository;
    
    public void setRepository(String qualifier) {
        this.baseRepository = (JpaRepository<T, ID>) context.getBean(qualifier);
    }
    
    public BasePageServiceImpl(ApplicationContext context) {
        this.context = context;
        this.setRepository(getJpaQualifierValue());
    }
    
    private  String getJpaQualifierValue() {
        JpaQualifier annotation = BasePageServiceImpl.class.getAnnotation(JpaQualifier.class);
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
    
    
    public List<T> getData(PageDataCriteria criteria)
    {
    	return null;
    }
}