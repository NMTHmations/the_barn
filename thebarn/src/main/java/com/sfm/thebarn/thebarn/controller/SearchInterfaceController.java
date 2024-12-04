package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchInterfaceController {

    @Autowired
    private AnimalsCRUD animalsRepository;

    @Autowired
    private BreedCodeCRUD breedCodeRepository;

    @Autowired
    private TypeCodesCRUD typeCodesRepository;

    @GetMapping("/search_interface")
    public String showSearchInterface(Model model) {
        List<Animals> animals = (List<Animals>)animalsRepository.findAll();
        List<BreedCodes> breeds = (List<BreedCodes>)breedCodeRepository.findAll();
        List<TypeCodes> types = (List<TypeCodes>)typeCodesRepository.findAll();
        model.addAttribute("breeds", breeds);
        model.addAttribute("types", types);
        model.addAttribute("animals", animals);
        return "search_interface";
    }

    @PostMapping("/search_interface")
    public String search(Model model, @RequestParam(value="query", required = false)String query,
                                      @RequestParam(value="option1", required = false)String option1,
                                      @RequestParam(value="option2", required = false)String option2,
                                      @RequestParam(value="breed", required = false)String breed,
                                      @RequestParam(value="type", required = false)String type) {

        List<Animals> animals = (List<Animals>)animalsRepository.findAll();
        List<BreedCodes> breeds = (List<BreedCodes>)breedCodeRepository.findAll();
        List<TypeCodes> types = (List<TypeCodes>)typeCodesRepository.findAll();

        model.addAttribute("breeds", breeds);
        model.addAttribute("types", types);
        model.addAttribute("animals", animals);
        //return "search_interface" + query;
        return "search_interface";
    }
}
