package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

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
