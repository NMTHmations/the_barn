package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static java.lang.System.in;

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

    //todo: bad request if params are left as null
    //todo: copy addAttributes from GetMapping to PostMapping aswell
    @PostMapping("/search_interface")
    public String search(Model model, @RequestParam(value="query")String query,
                                      @RequestParam(value="option1")String option1,
                                      @RequestParam(value="option2")String option2,
                                      @RequestParam(value="breed")String breed,
                                      @RequestParam(value="type")String type) {
        List<Animals> animals = (List<Animals>)animalsRepository.findAll();
        //check query values
        //if()
            // if all are empty: return all animals
        //check if breed=all (special case)
        //if()
        //check if type=all (special case)
        //if()
        /*for(var animal : animals) {
            model.addAttribute("animalID", );
        }*/
        model.addAttribute("rowCount", animals.size());
        return "search_interface";
    }
}
