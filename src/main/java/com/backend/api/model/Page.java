package com.backend.api.model;

import java.util.List;

public class Page<T> {
    private List<T> liste ; 
    private Pagination pagination ;
    public List<T> getListe() {
        return liste;
    }
    public void setListe(List<T> liste) {
        this.liste = liste;
    }
    public Pagination getPagination() {
        return pagination;
    }
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    } 
}
