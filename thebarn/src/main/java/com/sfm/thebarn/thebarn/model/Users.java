package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Users {
    @Id
    private String id;
    @Column(nullable = false)
    private String Passwd;
    @OneToOne
    @JoinColumn(name = "FarmId")
    public Farms FarmId;
}