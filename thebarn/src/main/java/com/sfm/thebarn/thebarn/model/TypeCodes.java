package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

@Entity
@Table(name="typecodes")
public class TypeCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public TypeCodes() {}
    public TypeCodes(String name) {
        this.name = name;
    }

    /*Getters and setters*/

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
}
