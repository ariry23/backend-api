package com.backend.api.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.backend.api.model.SqlParam;

@Component
public class UtilSql {
    public UtilSql() {
    }
    
    public Map<String, SqlParam> convertJsonToSqlParamMapArray(Map<String, Object> jsonData) {
        Map<String, SqlParam> mapArray = new HashMap<>();
        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            String key = entry.getKey(); 
            Object value = entry.getValue();
            SqlParam param = new SqlParam() ; 
            param.setValue(value);
            param.setColumn(key);
            mapArray.put(key, param);
        }
        return mapArray ; 
    }
    
    public static List<SqlParam> convertJsonToSqlParamArray(Map<String, Object> jsonData) {
        List<SqlParam> sqlParamList = new ArrayList<SqlParam>() ; 
        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            String key = entry.getKey(); 	
            Object value = entry.getValue();	
            SqlParam param = new SqlParam() ; 	
            param.setValue(value);
            param.setColumn(key);
            if(param.getValue() instanceof Integer)
            {
                if ((Integer) param.getValue() == 0) {
                    param.setComparator("isNull");
                } else {
                    param.setComparator("=");
                }
            }
            else if(param.getValue() instanceof String &&  param.getValue().toString().contains("dateInput") || param.getValue().toString().contains("dateTimeInput"))
            {
                String comparator =  param.getValue().toString().split(" ")[1] ; 
                param.setComparator(comparator);	
               // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ; 
                //param.setValeur(param.getValeur().toString().split(" ")[2]);
                System.out.println("comparator : " + comparator);
                System.out.println(" instance of date : " + param.getValue());
            }
            else if(param.getValue() instanceof String &&  !param.getValue().toString().contains("dateInput"))
            {
                param.setComparator("like");
            }
            sqlParamList.add(param);
          
        }
        return sqlParamList ; 
    }
    
}
