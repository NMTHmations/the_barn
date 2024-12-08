package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

@Entity
@Table(name="diseasetypes")
public class DiseaseTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String diseasetypename;
    public DiseaseTypes(){}
    public DiseaseTypes(String diseasetypename) {
        this.diseasetypename = diseasetypename;
    }

    /*Getters and setters*/

    public int getId() {
        return id;
    }

    public String getDiseasetypename() {
        return diseasetypename;
    }

    public void setDiseasetypename(String diseasetypename) {
        this.diseasetypename = diseasetypename;
    }
}
