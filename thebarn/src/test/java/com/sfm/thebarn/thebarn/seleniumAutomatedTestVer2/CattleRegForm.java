package com.sfm.thebarn.thebarn.seleniumAutomatedTestVer2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CattleRegForm {
    private String id;
    private String sex;
    private String breed;
    private String type;
    private String colour;
    private String birthdate;
    private String holding;
}
