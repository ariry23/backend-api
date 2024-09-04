/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.model;

import java.time.LocalDateTime;

/**
 *
 * @author pcg29
 */
public class ErrorDetails<T extends Exception>{
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private T exception; 

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public T getException() {
        return exception;
    }

    public void setException(T exception) {
        this.exception = exception;
    }
    
    public ErrorDetails(String message, String details , T exception) {
        super();
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
        this.exception = exception ; 
    }
}