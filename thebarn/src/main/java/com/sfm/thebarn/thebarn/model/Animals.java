package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
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

    public Animals() {}

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

    /*Getters and setters*/

    public void SetPrevId(String PrevId)
    {
        this.PrevId = PrevId;
    }

    public void SetDeathDate(Date DeathDate)
    {
        this.DeathDate = DeathDate;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFatherId()
    {
        return fatherid.getId();
    }

    public void setFatherId(String fatherId)
    {
        fatherid.setId(fatherId);
    }

    public String getMotherId()
    {
        return motherid.getId();
    }

    public void setMotherId(String id)
    {
        fatherid.setId(id);
    }
    public void SetBirthDate(Date BirthDate)
    {
        this.BirthDate = BirthDate;
    }

    public Date getBirthDate()
    {
        return BirthDate;
    }

    public Date getDeathDate()
    {
        return DeathDate;
    }

    public String getPrevId()
    {
        return PrevId;
    }

    public void setColor(int id)
    {
        color.setId(id);
    }

    public String getColor()
    {
        return color.getName();
    }

    public String getBreed()
    {
        return breed.getName();
    }

    public void SetType(int id)
    {
        type.setId(id);
    }

    public int getType()
    {
        return type.getId();
    }
}
