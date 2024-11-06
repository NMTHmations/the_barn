package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="breedcodes")
public class BreedCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public BreedCodes() {}
    public BreedCodes(String name) {
        this.name = name;
    }
}
