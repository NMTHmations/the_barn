package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Animals;
import com.sfm.thebarn.thebarn.model.AnimalsCRUD;
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

    /*@GetMapping("/search_interface")
    public String hello(Model model, @RequestParam(value="name")String name) {
        model.addAttribute("name", name);
        return "search_interface";
    }*/

    @GetMapping("/search_interface")
    public String showSearchInterface(Model model) {
        List<Animals> animals = (List<Animals>)animalsRepository.findAll();
        model.addAttribute("rowCount", animals.size());
        return "search_interface";
    }

    @PostMapping("/search_interface")
    public String search(Model model, @RequestParam(value="query")String query,
                                      @RequestParam(value="option1")String option1,
                                      @RequestParam(value="option2")String option2,
                                      @RequestParam(value="breed")String breed,
                                      @RequestParam(value="type")String type) {
            /*public String search(Model model) {*/
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
