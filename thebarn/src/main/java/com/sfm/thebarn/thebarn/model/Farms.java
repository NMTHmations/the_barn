package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Farms")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
}
