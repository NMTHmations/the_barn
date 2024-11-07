package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="diseaselog")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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

    public DiseaseLog(DiseaseTypes type, Animals animal, Date date) {
        this.diseaseTypes = type;
        this.animalid = animal;
        this.date = date;
    }
}
