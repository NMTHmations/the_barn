package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MedicalSearchController {
    @Autowired
    private UserService userService;

    @Autowired
    private UsersCRUD usersCRUD;

    @Autowired
    private DiseaseLogCRUD diseaseRepository;

    @Autowired
    private DiseaseTypesCRUD diseaseTypesRepository;

    public List<DiseaseLog> diseaseLogsList(Users usr) {
        // if nothing was set: return all logs
        if (usr.getFarmId() == null) {
            return (List<DiseaseLog>) diseaseRepository.findAll();
        }
        return diseaseRepository.findAllByFarmId(usr.FarmId.getId());
    }

    @GetMapping("/medical_search_interface")
    public String showMedicalSearch(HttpServletRequest request, Model model) {
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        String username = (String) request.getSession(false).getAttribute("userID");
        if (usersCRUD.findById(username).get().FarmId == null) {
            model.addAttribute("holding","Tenyészet hozzáadása");
        }
        List<DiseaseTypes> diseaseTypes = (List<DiseaseTypes>)diseaseTypesRepository.findAll();
        List<DiseaseLog> diseaseLogs = diseaseLogsList(usersCRUD.findById(username).get());
        model.addAttribute("diseaseTypes", diseaseTypes);
        model.addAttribute("diseaseLogs", diseaseLogs);
        model.addAttribute("username",username);
        return "medical_search_interface";
    }

    @PostMapping("/medical_search_interface")
    public String search(Model model, @RequestParam(value="query", required = false)String query,
                                      @RequestParam(value="disease", required = false)String disease,
                                      HttpServletRequest request) {

        String userID = (String) request.getSession(false).getAttribute("userID");
        Users usr = usersCRUD.findById(userID).get();

        List<DiseaseLog> diseaseLogs = diseaseLogsList(usr);

        // if a search query was set
        if(!query.isEmpty()) {
            diseaseLogs = (List<DiseaseLog>)diseaseRepository.findByAnimalIdOrFarmName(query);
        }

        // if a breed was specified
        if(disease.compareTo("all") != 0) {
            List<DiseaseLog> searchResults = new ArrayList<DiseaseLog>();
            for (var diseaseLog : diseaseLogs) {
                if (diseaseLog.getDiseaseTypes().getId() == Integer.parseInt(disease)) {
                    searchResults.add(diseaseLog);
                }
            }
            diseaseLogs = searchResults;
        }

        if (usr.getFarmId() == null) {
            model.addAttribute("holding","Tenyészet hozzáadása");
        }
        // get all disease types
        List<DiseaseTypes> diseaseTypes = (List<DiseaseTypes>)diseaseTypesRepository.findAll();

        // add dynamic values and search results to frontend
        model.addAttribute("diseaseTypes", diseaseTypes);
        model.addAttribute("diseaseLogs", diseaseLogs);
        model.addAttribute("username",userID);

        return "medical_search_interface";
    }
}
