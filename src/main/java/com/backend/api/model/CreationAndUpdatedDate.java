/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.api.model;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;

/**
 *
 * @author pcg29
 */
@Embeddable
public class CreationAndUpdatedDate {
    private LocalDateTime creationDate ; 
    private LocalDateTime updatedDate ; 

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public CreationAndUpdatedDate() {
    }
    
}
