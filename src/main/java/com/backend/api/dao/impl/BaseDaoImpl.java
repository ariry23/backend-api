/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.dao.impl;

import com.backend.api.model.PageDataCriteria;
import com.backend.api.model.SqlParam;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pcg29
 */
@Repository
public class BaseDaoImpl {
    /*private Object listEntity;
    private EntityManager entityManager ; 
    
    private CriteriaBuilder criteriaBuilder ; 
    private Predicate predicate ; 
    public BaseDaoImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager ; 
        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }
    public void setListEntity(Object listEntity)
    {
        this.listEntity=listEntity;
    }
    public List<?> search(PageDataCriteria pageDataCriteria) 
    {
        Predicate predicate = null ;
        CriteriaQuery<?> query = criteriaBuilder.createQuery(listEntity.getClass());
        Root<?> root = query.from(listEntity.getClass());
        for(SqlParam sqlParam : pageDataCriteria.getSqlParamList())
        {
            
            if(sqlParam.getComparator().equalsIgnoreCase("like"))
            {
                Predicate pred = criteriaBuilder.like( root.get(sqlParam.getColumn()), "%"+sqlParam.getValue()+"%");
                if (pred != null) {
                    if (predicate == null) {
                        predicate = pred;
                    } else {
                        predicate = criteriaBuilder.and(predicate ,  pred ) ;    
                    }
                }
            }
            if(sqlParam.getComparator().equalsIgnoreCase("="))
            {
                Predicate pred  =  criteriaBuilder.equal(root.get(sqlParam.getColumn()), sqlParam.getValue());
                if (pred != null) {
                    if (predicate == null) {
                        predicate = pred;
                    } else {
                        predicate = criteriaBuilder.and(predicate ,  pred) ;    
                    }
                }
            }
            if(sqlParam.getComparator().equalsIgnoreCase("isNull"))
            {
                Predicate pred  =  criteriaBuilder.isNull(root.get(sqlParam.getColumn()));
                if (pred != null) {
                    if (predicate == null) {
                        predicate = pred;
                    } else {
                        predicate = criteriaBuilder.and(predicate ,  pred) ;    
                    }
                }
            }
        }
        return null ; 
    } */
}
