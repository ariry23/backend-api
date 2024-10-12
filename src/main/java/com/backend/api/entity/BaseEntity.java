package com.backend.api.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class BaseEntity {
	 	@Id
	    private int id ;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		} 
	 	
}
