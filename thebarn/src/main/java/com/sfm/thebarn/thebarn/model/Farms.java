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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public Farms(String id, String FarmName, int ZIPCode, String Settlement, String Street, int StreetNumber) {
        this.id = id;
        this.FarmName = FarmName;
        this.ZIPCode = ZIPCode;
        this.Settlement = Settlement;
        this.Street = Street;
        this.StreetNumber = StreetNumber;
    }
}
