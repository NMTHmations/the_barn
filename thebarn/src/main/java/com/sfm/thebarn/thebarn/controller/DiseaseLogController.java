package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/disease-registration")
public class DiseaseLogController {

    @Autowired
    private DiseaseLogCRUD diseaseLogCRUD;

    @Autowired
    private DiseaseTypesCRUD diseaseTypesCRUD;

    @Autowired
    private AnimalsCRUD animalsCRUD;

    @GetMapping
    public String showDiseaseRegistrationForm(Model model) {
        List<DiseaseTypes> diseaseTypes = (List<DiseaseTypes>) diseaseTypesCRUD.findAll();
        List<Animals> animals = (List<Animals>) animalsCRUD.findAll();

        model.addAttribute("diseaseTypes", diseaseTypes);
        model.addAttribute("animals", animals);

        return "disease/registration"; // Térjünk vissza a regisztrációs oldalra
    }

    @PostMapping
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
