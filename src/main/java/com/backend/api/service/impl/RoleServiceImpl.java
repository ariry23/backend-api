/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.service.impl;

import com.backend.api.annotation.JpaQualifier;
import com.backend.api.entity.Role;
import com.backend.api.model.PageDataCriteria;
import com.backend.api.service.RoleService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author pcg29
 */
@JpaQualifier("roleRepository")
@Service
public class RoleServiceImpl extends BasePageServiceImpl<Role, Integer> implements RoleService{

    
    
    
    
    public RoleServiceImpl(ApplicationContext context) {
       this.injectDependency(context);
    } 
    
    @Override
    public Role save(Role entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Role> getData(PageDataCriteria criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
