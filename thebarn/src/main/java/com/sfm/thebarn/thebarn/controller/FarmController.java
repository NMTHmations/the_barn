package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Farms;
import com.sfm.thebarn.thebarn.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@Controller
@RequestMapping("/farm_registration")
public class FarmController {

    @Autowired
    private FarmRepository farmsRepository;

    private static final Pattern FARM_ID_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{5}-\\d{5}$");

    @GetMapping
    public String showRegistrationForm() {
        return "farm/registration";
    }

    @PostMapping
    public String registerFarm(
            @RequestParam("farmId") String farmId,
            @RequestParam("farmName") String farmName,
            @RequestParam("zipCode") int zipCode,
            @RequestParam("settlement") String settlement,
            @RequestParam("street") String street,
            @RequestParam("streetNumber") int streetNumber,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        // Tenyészetkód validáció
        if (!FARM_ID_PATTERN.matcher(farmId).matches()) {
            model.addAttribute("errorMessage", "Helytelen tenyészetkód! Helyes formátum: HU-12345-12345");
            return "farm/registration";
        }

        Farms farm = new Farms(farmId, farmName, zipCode, settlement, street, streetNumber);

        farmsRepository.save(farm);

        return "redirect:/";
    }
}
