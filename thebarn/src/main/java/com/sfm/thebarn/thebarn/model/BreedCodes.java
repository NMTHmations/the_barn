package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="breedcodes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BreedCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public BreedCodes(String name) {
        this.name = name;
    }
}
