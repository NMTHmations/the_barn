package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Farms")
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
