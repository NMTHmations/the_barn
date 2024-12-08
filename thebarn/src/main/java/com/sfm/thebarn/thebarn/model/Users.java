package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
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

    /*Getters and setters*/

    /*
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

    public String getFarmId() { return (FarmId != null) ? FarmId.getId() : null; }

    public void setFarmId(Farms FarmId) {
        this.FarmId = FarmId;
    }*/
}