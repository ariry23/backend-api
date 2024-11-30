package com.backend.api.model;

public class ListOrder{
    private String column ; 
    private Order order ; 


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
        
}
