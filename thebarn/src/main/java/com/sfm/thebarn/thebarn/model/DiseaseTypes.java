package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="diseasetypes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DiseaseTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String diseasetypename;
    public DiseaseTypes(String diseasetypename) {
        this.diseasetypename = diseasetypename;
    }
}
