package com.backend.api.model;
public class SqlParam {
    private String column ; 
    private String comparator ; 
    private Object value ; 
    private String inclusif ; 
    private String condition ; 
    private boolean isIgnoreCase ; 
    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getComparator() {
        return comparator;
    }

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }


    public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isIgnoreCase() {
		return isIgnoreCase;
	}

	public void setIgnoreCase(boolean isIgnoreCase) {
		this.isIgnoreCase = isIgnoreCase;
	}

	public String getInclusif() {
        return inclusif;
    }

    public void setInclusif(String inclusif) {
        this.inclusif = inclusif;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isIsIgnoreCase() {
        return isIgnoreCase;
    }

    public void setIsIgnoreCase(boolean isIgnoreCase) {
        this.isIgnoreCase = isIgnoreCase;
    }
    
    public SqlParam() {
        this.isIgnoreCase = true ; 
        this.inclusif = "and " ; 
    }
    
    public void buildCondition()
    {
        if(this.value instanceof Integer && this.value != null )
        { 
            try {
                int var = (Integer) this.value;
                this.comparator = " = " ; 
                this.condition = this.inclusif + this.column + this.comparator + String.valueOf(var) + " "; 
               
            }
            catch(Exception e)
            {
                System.out.println("Mal formatted Integer") ;
            }
        }
        else if(this.value instanceof String && this.value != null && !((String) this.value).isEmpty())
        {
            
            try{
                String formatedValue = (String) this.value ; 
                this.comparator = " like ";  
                String formatedColumn = this.column ; 
                if(this.isIgnoreCase)
                {
                   formatedColumn =  "lower(" + this.column + ") " ;   
                   formatedValue = "lower('%" + this.value + "%') ";
                }
                this.condition = this.inclusif + formatedColumn + this.comparator + formatedValue ;
            }
            catch(Exception e)
            {
                System.out.println("Mal formatted String") ;
            }
        }
        else{
            
            this.condition = "" ; 
        }
        
    }
    
    
}
