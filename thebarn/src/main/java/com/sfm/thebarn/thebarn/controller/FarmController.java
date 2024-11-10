package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Farms;
import com.sfm.thebarn.thebarn.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/farm-registration")
public class FarmController {

    @Autowired
    private FarmRepository farmsRepository;

    @GetMapping
    public String showRegistrationForm() {
        return "farm/registration";
    }

    @PostMapping
    public String registerFarm(
            @RequestParam("farmId") String farmId,
            @RequestParam("FarmName") String farmName,
            @RequestParam("ZIPCode") int zipCode,
            @RequestParam("Settlement") String settlement,
            @RequestParam("Street") String street,
            @RequestParam("StreetNumber") int streetNumber
    ) {
        Farms farm = new Farms(farmId, farmName, zipCode, settlement, street, streetNumber);

        farmsRepository.save(farm);

        return "redirect:/";
    }
}
