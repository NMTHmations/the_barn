package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="diseaselog")
public class DiseaseLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @ManyToOne
    @JoinColumn(name="Type_Id")
    private DiseaseTypes diseaseTypes;
    @ManyToOne
    @JoinColumn(name="Animal_id")
    private Animals animalid;
    @Column(nullable = false)
    private Date date;
    private String description;

    public DiseaseLog(){}
    public DiseaseLog(DiseaseTypes type, Animals animal, Date date) {
        this.diseaseTypes = type;
        this.animalid = animal;
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*Getters and setters*/

    public int getNumber() {
        return number;
    }
    public String GetAnimalId() {
        return animalid.getId();
    }
    public void setAnimalid(Animals animalid) {
        this.animalid = animalid;
    }
    public void SetDate(Date date) {
        this.date = date;
    }
    public Date getDate()
    {
        return date;
    }
    public String getDescription() {
        return description;
    }
}
