/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.util.pageFilter;
import com.backend.api.model.MyEntry;
import com.backend.api.model.SqlParam;

public class StringHandler implements JsonDataHandler{
	private JsonDataHandler next;
	@Override
	public void setNext(JsonDataHandler handler) {
		this.next = handler ; 
		
	}

	@Override
	public SqlParam handleRequest(MyEntry<String , Object> entry) {
		SqlParam param = new SqlParam() ; 
		if (entry.getValue() instanceof String) {
				param.setColumn(entry.getKey());
				param.setValue(entry.getValue());
                param.setComparator("like");
            
        } else if (next != null) {
            param = next.handleRequest(entry);
        }
		return param ; 
	}

}