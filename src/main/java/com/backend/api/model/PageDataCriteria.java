package com.backend.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageDataCriteria {
    private ListOrder listOrder ; 
    private List<SqlParam> sqlParamList ; 

    public ListOrder getListOrder() {
        return listOrder;
    }

    public void setListOrder(ListOrder listOrder) {
        this.listOrder = listOrder;
    }

    public List<SqlParam> getSqlParamList() {
        return sqlParamList;
    }

    public void setSqlParamList(List<SqlParam> sqlParamList) {
        this.sqlParamList = sqlParamList;
    }
}
