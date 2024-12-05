package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Farms")
public class Farms {
    @Id
    private String id;
    @Column(nullable = false)
    private String FarmName;
    @Column(nullable = false)
    private int ZIPCode;
    @Column(nullable = false)
    private String Settlement;
    @Column(nullable = false)
    private String  Street;
    @Column(nullable = false)
    private int  StreetNumber;

    public Farms(){}

    public Farms(String id, String FarmName, int ZIPCode, String Settlement, String Street, int StreetNumber) {
        this.id = id;
        this.FarmName = FarmName;
        this.ZIPCode = ZIPCode;
        this.Settlement = Settlement;
        this.Street = Street;
        this.StreetNumber = StreetNumber;
    }

    /*Getters and Setters*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFarmName() {
        return FarmName;
    }

    public void setFarmName(String farmName) {
        FarmName = farmName;
    }

    public int getZIPCode() {
        return ZIPCode;
    }

    public void setZIPCode(int ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public String getSettlement() {
        return Settlement;
    }

    public void setSettlement(String settlement) {
        Settlement = settlement;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        StreetNumber = streetNumber;
    }
}
