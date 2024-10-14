package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class Users {
    @Id
    private String id;
    @Column(nullable = false)
    private String Passwd;
    @OneToOne
    @JoinColumn(name = "FarmId")
    public Farms FarmId;
    public Users() {}
    public Users(String id, String Passwd, Farms Farms) {
        this.id = id;
        this.Passwd = Passwd;
        this.FarmId = Farms;
    }

    /*Getters and setters*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    public Farms getFarmId() {
        return FarmId;
    }

    public void setFarmId(Farms FarmId) {
        this.FarmId = FarmId;
    }
}