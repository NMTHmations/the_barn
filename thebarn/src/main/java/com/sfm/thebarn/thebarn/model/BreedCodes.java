package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

@Entity
@Table(name="breedcodes")
public class BreedCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public BreedCodes() {}
    public BreedCodes(String name) {
        this.name = name;
    }

    /*Getters and setters*/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
