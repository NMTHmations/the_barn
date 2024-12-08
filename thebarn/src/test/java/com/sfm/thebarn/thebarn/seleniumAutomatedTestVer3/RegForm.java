package com.sfm.thebarn.thebarn.seleniumAutomatedTestVer3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegForm {
    private String username;
    private String farmId;
    private String farmName;
    private String Settlement;
    private String Address;
}
