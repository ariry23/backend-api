/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.util.pageFilter;
import com.backend.api.model.SqlParam;
import java.util.Map;

public class StringHandler implements JsonDataHandler{
	private JsonDataHandler next;
	@Override
	public void setNext(JsonDataHandler handler) {
		this.next = handler ; 
		
	}

	@Override
	public Object handleRequest(Map.Entry<String , Object> entry) {
		
		if (entry.getValue() instanceof String) {
                    SqlParam param = new SqlParam();
                    param.setColumn(entry.getKey());
                    param.setValue(entry.getValue());
                    param.setComparator("like");
                    return param;
            
        } else if (next != null) {
            return next.handleRequest(entry);
        }
		return null ; 
	}

}