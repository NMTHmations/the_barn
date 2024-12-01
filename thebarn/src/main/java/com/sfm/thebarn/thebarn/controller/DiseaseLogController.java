package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class DiseaseLogController {

    @Autowired
    private DiseaseLogCRUD diseaseLogCRUD;

    @Autowired
    private DiseaseTypesCRUD diseaseTypesCRUD;

    @Autowired
    private AnimalsCRUD animalsCRUD;

    @GetMapping("/disease_registration")
    public String showDiseaseRegistrationForm(Model model) {
        return "disease_registration"; // Térjünk vissza a statikus sablonhoz
    }

    @PostMapping("/disease_registration")
    public String registerDisease(
            @RequestParam("animalId") String animalId,
            @RequestParam("diseaseType") int diseaseTypeId,
            @RequestParam("date") Date date,
            @RequestParam("description") String description
    ) {
        Animals animal = animalsCRUD.findById(animalId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Animal ID"));
        DiseaseTypes diseaseType = diseaseTypesCRUD.findById(diseaseTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Disease Type ID"));

        DiseaseLog diseaseLog = new DiseaseLog(diseaseType, animal, date);
        diseaseLog.setDescription(description);

        diseaseLogCRUD.save(diseaseLog);

        return "redirect:/";
    }
}
