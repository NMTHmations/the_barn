package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
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

        // if nothing was set: return all animals
        List<Animals> animals = (List<Animals>)animalsRepository.findAll();

        // if a search query was set
        if(!query.isEmpty()) {
            //animals = animalsRepository.findById(query).stream().toList();
            animals = (List<Animals>)animalsRepository.findByIdOrFarmIdOrFarmName(query);
        }

        // if a checkbox was set
        if((option1 != null && !option1.isEmpty()) || (option2 != null && !option2.isEmpty())) {
            List<Animals> searchResults = new ArrayList<Animals>();
            for(var animal : animals) {
                // if 'üsző' was checked
                if(option1 != null && !option1.isEmpty()) {
                    if(animal.isSex()) {
                        searchResults.add(animal);
                    }
                }

                // if 'bika' was checked
                if(option2 != null && !option2.isEmpty()) {
                    if(!animal.isSex()) {
                        searchResults.add(animal);
                    }
                }
            }
            animals = searchResults;
        }

        // if a breed was specified
        if(breed.compareTo("all") != 0) {
            List<Animals> searchResults = new ArrayList<Animals>();
            for (var animal : animals) {
                if (animal.getBreed().getId() == Integer.parseInt(breed)) {
                    searchResults.add(animal);
                }
            }
            animals = searchResults;
        }

        // if a type was specified
        if(type.compareTo("all") != 0) {
            List<Animals> searchResults = new ArrayList<Animals>();
            for (var animal : animals) {
                if (animal.getType().getId() == Integer.parseInt(type)) {
                    searchResults.add(animal);
                }
            }
            animals = searchResults;
        }


        // get all breeds and types
        List<BreedCodes> breeds = (List<BreedCodes>)breedCodeRepository.findAll();
        List<TypeCodes> types = (List<TypeCodes>)typeCodesRepository.findAll();

        // add dynamic dropdown values and search results to frontend
        model.addAttribute("breeds", breeds);
        model.addAttribute("types", types);
        model.addAttribute("animals", animals);

        return "search_interface";
    }
}
