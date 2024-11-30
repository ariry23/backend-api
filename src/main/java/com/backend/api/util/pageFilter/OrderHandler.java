/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.util.pageFilter;

import com.backend.api.model.ListOrder;
import com.backend.api.model.SqlParam;
import java.util.Map;

/**
 *
 * @author pcg29
 */
public class OrderHandler implements JsonDataHandler{

    private JsonDataHandler next ;

    @Override
    public void setNext(JsonDataHandler handler) {
            this.next = handler ; 
    }

    @Override
    public Object handleRequest(Map.Entry<String, Object> entry) {
        var listOrder = new ListOrder() ; 
        if (entry.getKey().equals("order") && entry.getValue()!=null) {
                return entry.getValue() ; 
                        
			
        } else if (next != null) {
            listOrder = (ListOrder) next.handleRequest(entry);
        }
        return listOrder ; 
    }
    
}
