package com.backend.api.util.pageFilter;

import javax.management.openmbean.InvalidOpenTypeException;

import com.backend.api.model.MyEntry;
import com.backend.api.model.SqlParam;

public class IntegerHandler implements JsonDataHandler{
	private JsonDataHandler next ;

	@Override
	public void setNext(JsonDataHandler handler) {
		this.next = handler ; 
		
	}

	@Override
	public SqlParam handleRequest(MyEntry<String , Object> entry) {
		SqlParam param = new SqlParam() ; 
		if (entry.getValue() instanceof Integer) {
			if ((Integer) entry.getValue() == 0) {
                param.setComparator("isNull");
                param.setValue(entry.getValue());
                param.setColumn(entry.getKey());
                
            } else {
                param.setComparator("=");
            }
			
        } else if (next != null) {
            param = next.handleRequest(entry);
        }
		return param ; 
	} 
}
