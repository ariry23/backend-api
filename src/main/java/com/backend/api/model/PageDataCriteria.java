package com.backend.api.model;

import java.util.HashMap;
import java.util.Map;

public class PageDataCriteria {
	ListOrder listOrder ; 
	Map<String , ?> criteria ;
	public ListOrder getListOrder() {
		return listOrder;
	}
	public void setListOrder(ListOrder listOrder) {
		this.listOrder = listOrder;
	}
	public Map<String, ?> getCriteria() {
		return criteria;
	}
	public void setCriteria(Map<String, ?> criteria) {
		this.criteria = criteria;
	}
	
}
