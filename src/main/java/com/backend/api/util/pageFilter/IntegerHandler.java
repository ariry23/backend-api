package com.backend.api.util.pageFilter;

import javax.management.openmbean.InvalidOpenTypeException;

import com.backend.api.model.MyEntry;
import com.backend.api.model.SqlParam;
import java.util.Map;

public class IntegerHandler implements JsonDataHandler{
	private JsonDataHandler next ;

	@Override
	public void setNext(JsonDataHandler handler) {
		this.next = handler ; 
		
	}

	@Override
	public Object handleRequest(Map.Entry<String , Object> entry) {
		
            if (entry.getValue() instanceof Integer) {
                SqlParam param = new SqlParam() ; 
                param.setValue(entry.getValue());
                        param.setColumn(entry.getKey());
                if ((Integer) entry.getValue() == 0) {
                    param.setComparator("isNull");
                } else {
                    param.setComparator("=");
                }
                return param ; 

            } else if (next != null) {
                return next.handleRequest(entry);
            }
            return null ; 
	} 
}
