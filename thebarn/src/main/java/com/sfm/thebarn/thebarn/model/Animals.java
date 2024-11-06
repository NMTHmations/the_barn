package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="animals")
public class Animals {
    @Id
    private String id;

    @Column(nullable = false)
    private boolean sex;

    @ManyToOne
    @JoinColumn(name="FatherId")
    private Animals fatherid;

    @ManyToOne
    @JoinColumn(name="MotherId")
    private Animals motherid;

    @ManyToOne
    @JoinColumn(name="FarmId")
    private Farms farmid;

    @Column(nullable = false)
    private Date BirthDate;

    private Date DeathDate;

    @ManyToOne
    @JoinColumn(name="color")
    private ColourCodes color;

    @ManyToOne
    @JoinColumn(name="breed")
    private BreedCodes breed;

    @ManyToOne
    @JoinColumn(name="type")
    private TypeCodes type;

    private String PrevId;

    public Animals(String id,Boolean sex,Animals father,Animals mother,Farms farm,Date Birth,ColourCodes color,BreedCodes breed,TypeCodes type)
    {
        this.id = id;
        this.sex = sex;
        this.fatherid = father;
        this.motherid = mother;
        this.farmid = farm;
        this.BirthDate = Birth;
        this.color = color;
        this.breed = breed;
        this.type = type;
    }
}
