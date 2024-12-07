package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Controller
public class DiseaseLogController {

    @Autowired
    private DiseaseLogCRUD diseaseLogCRUD;

    @Autowired
    private DiseaseTypesCRUD diseaseTypesCRUD;

    @Autowired
    private AnimalsCRUD animalsCRUD;
    @Autowired
    private UsersCRUD usersCRUD;

    @Autowired
    private UserService userService;

    @GetMapping("/disease_registration")
    public String showDiseaseRegistrationForm(Model model,HttpServletRequest request) {
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        return "disease_registration"; // Térjünk vissza a statikus sablonhoz
    }

    @PostMapping("/disease_registration")
    public String registerDisease(
            @RequestParam("animalId") String animalId,
            @RequestParam("diseaseType") int diseaseTypeId,
            @RequestParam("date") Date date,
            @RequestParam(value = "description", defaultValue = "") String description,
            Model model,
            HttpServletRequest request
    ) {
        if (animalsCRUD.findById(animalId).isEmpty()) // if the animal don't exists
        {
            model.addAttribute("IDerror","A megadott állat nem létezik!");
            return "/disease_registration";
        }
        Animals animal = animalsCRUD.findById(animalId).get();
        String username = (String) request.getSession().getAttribute("userID");
        if (usersCRUD.findById(username).get().getFarmId() != null) { // if user is not admin
            if (!usersCRUD.findById(username).get().getFarmId().getId().equals(animal.getFarmid().getId())) { // if the user doesn't own the animal
                model.addAttribute("FarmIDerror","A megadott állat nem az ön állata!");
                return "/disease_registration";
            }
        }
        if (date.toLocalDate().isAfter(LocalDateTime.now().toLocalDate().plusDays(1))) // if the given day after today's
        {
            return "/disease_registration";
        }
        DiseaseTypes diseaseType = diseaseTypesCRUD.findById(diseaseTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Disease Type ID"));

        if (description.length() > 255) // if description's length more than 255 characters
        {
            model.addAttribute("LengthError","Leírás túllépi a 255 karakternyi limitet!");
            return "/disease_registration";
        }

        DiseaseLog diseaseLog = new DiseaseLog(diseaseType, animal, date);

        diseaseLog.setDescription(description);

        diseaseLogCRUD.save(diseaseLog);
        return "redirect:/";
    }
}
