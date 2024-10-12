package com.backend.api.entity;

import java.util.logging.Logger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {

    private static final Logger LOG = Logger.getLogger(Role.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence_generator")
    @SequenceGenerator(name = "role_sequence_generator", sequenceName = "role_seq", allocationSize = 1)
    private int id ; 
    @Column(name="name")
    private String name ; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name=" + name + '}';
    }

    public Role() {
    }
    
}

