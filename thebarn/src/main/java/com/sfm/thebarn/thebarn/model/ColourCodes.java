package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="colourcodes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ColourCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    public ColourCodes(String name) {
        this.name = name;
    }
}
