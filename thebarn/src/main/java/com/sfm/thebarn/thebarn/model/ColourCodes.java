package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

@Entity
@Table(name="colourcodes")
public class ColourCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    public ColourCodes() {}
    public ColourCodes(String name) {
        this.name = name;
    }

    /*Getters and Setters*/

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
}
