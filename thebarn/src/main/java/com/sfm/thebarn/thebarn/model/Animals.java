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

    public void setPrevId(String PrevId)
    {
        this.PrevId = PrevId;
    }

    public void setDeathDate(Date DeathDate)
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

    public String getFatherId() { return (motherid != null) ? motherid.getId() : null; }

    public void setFatherId(Animals fatherId) { this.fatherid = fatherId; }

    public void setFarmId(Farms farm) { this.farmid = farm; }

    public String getMotherId() { return (motherid != null) ? motherid.getId() : null; }

    public void setMotherId(Animals motherId)
    {
        this.motherid = motherId;
    }
    public void setBirthDate(Date BirthDate)
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

    public void setColor(ColourCodes color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color.getName();
    }

    public String getBreed()
    {
        return breed.getName();
    }

    public int getBreedId()
    {
        return breed.getId();
    }

    public int getTypeId()
    {
        return type.getId();
    }

    public int getColorId()
    {
        return color.getId();
    }

    public void setBreed(BreedCodes breed)
    {
        this.breed = breed;
    }

    public void setType(TypeCodes type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type.getName();
    }

    public boolean getSex() {return sex;} // needed an additional getter

    public void setSex(boolean sex) { this.sex = sex; } // needed an additional setter

    public String getFarmid() {
        return farmid.getId();
    }
}
