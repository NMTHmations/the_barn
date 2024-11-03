package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Farms;
import com.sfm.thebarn.thebarn.repository.FarmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm-registration")
public class FarmController {

    private final FarmRepository farmRepository;

    public FarmController(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @GetMapping
    public String showFarmRegistrationForm(Model model) {
        model.addAttribute("farm", new Farms());
        return "farm/registration";
    }

    @PostMapping
    public String registerFarm(Farms farm) {
        farmRepository.save(farm);
        return "redirect:/success";
    }
}
