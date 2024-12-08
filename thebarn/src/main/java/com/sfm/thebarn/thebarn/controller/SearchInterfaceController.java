package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchInterfaceController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersCRUD usersCRUD;

    @Autowired
    private AnimalsCRUD animalsRepository;

    @Autowired
    private BreedCodeCRUD breedCodeRepository;

    @Autowired
    private TypeCodesCRUD typeCodesRepository;

    public List<Animals> animalsList(Users usr) {
        // if nothing was set: return all animals
        if (usr.getFarmId() == null) {
            return (List<Animals>) animalsRepository.findAll();
        }
        return animalsRepository.findAllByFarmId(usr.FarmId.getId());
    }

    @GetMapping("/")
    public String showSearchInterface(HttpServletRequest request, Model model) {
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        String username = (String) request.getSession(false).getAttribute("userID");
        List<Animals> animals = animalsList(usersCRUD.findById(username).get());
        List<BreedCodes> breeds = (List<BreedCodes>)breedCodeRepository.findAll();
        List<TypeCodes> types = (List<TypeCodes>)typeCodesRepository.findAll();
        if (usersCRUD.findById(username).get().FarmId == null) {
            model.addAttribute("holding","Tenyészet hozzáadása");
        }
        model.addAttribute("breeds", breeds);
        model.addAttribute("types", types);
        model.addAttribute("animals", animals);
        model.addAttribute("username",username);
        return "search_interface";
    }

    @PostMapping("/")
    public String search(Model model, @RequestParam(value="query", required = false)String query,
                                      @RequestParam(value="option1", required = false)String option1,
                                      @RequestParam(value="option2", required = false)String option2,
                                      @RequestParam(value="breed", required = false)String breed,
                                      @RequestParam(value="type", required = false)String type,
                                      HttpServletRequest request) {
        String userID = (String) request.getSession(false).getAttribute("userID");
        Users usr = usersCRUD.findById(userID).get();

        List<Animals> animals = animalsList(usr);

        // if a search query was set
        if(!query.isEmpty() && usr.FarmId == null) {
            animals = (List<Animals>)animalsRepository.findByIdOrFarmIdOrFarmName(query);
            model.addAttribute("holding","Tenyészet hozzáadása");
        }
        else if (!query.isEmpty() && usr.FarmId != null)
        {
            animals = (List<Animals>) animalsRepository.findByIdFixedFarmId(query, usr.FarmId.getId());
        }

        // if a checkbox was set
        if((option1 != null && !option1.isEmpty()) || (option2 != null && !option2.isEmpty())) {
            List<Animals> searchResults = new ArrayList<Animals>();
            for(var animal : animals) {
                // if 'üsző' was checked
                if(option1 != null && !option1.isEmpty()) {
                    if(animal.getSex()) {
                        searchResults.add(animal);
                    }
                }

                // if 'bika' was checked
                if(option2 != null && !option2.isEmpty()) {
                    if(!animal.getSex()) {
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
        model.addAttribute("breedCodes", breeds);
        model.addAttribute("username",userID);
        return "search_interface";
    }
}
