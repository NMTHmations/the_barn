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
@Table(name="typecodes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TypeCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public TypeCodes(String name) {
        this.name = name;
    }

}
