/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.util.pageFilter;
import com.backend.api.model.MyEntry;
import com.backend.api.model.SqlParam;

public interface JsonDataHandler {
    void setNext(JsonDataHandler handler);  
    SqlParam handleRequest(MyEntry<String , Object> entry);
}
