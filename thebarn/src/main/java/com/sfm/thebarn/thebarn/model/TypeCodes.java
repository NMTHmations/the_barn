package com.sfm.thebarn.thebarn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//todo vv TEMP (uncomment before final)
/*@NoArgsConstructor
@AllArgsConstructor
@Builder*/
@Table(name="typecodes")
public class TypeCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public TypeCodes(String name) {
        this.name = name;
    }

    //todo vv TEMP (remove before final)
    public TypeCodes(){}
}
