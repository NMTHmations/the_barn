package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/search_interface")
    public String search(Model model, @RequestParam(value="query", required = false)String query,
                                      @RequestParam(value="option1", required = false)String option1,
                                      @RequestParam(value="option2", required = false)String option2,
                                      @RequestParam(value="breed", required = false)String breed,
                                      @RequestParam(value="type", required = false)String type) {

        List<Animals> animals = (List<Animals>)animalsRepository.findAll();

        StringBuilder sql = new StringBuilder();
        sql.append("select * from Animals");
        // if searchbar is empty
        if(query.isBlank()) {
            // if any other value is set
            if(option1.compareTo("on") == 0 || option2.compareTo("on") == 0 || breed.compareTo("all") != 0 || type.compareTo("all") != 0) {
                sql.append(" where ");
                // list for concatenating sql params into one sql query
                List<String> params = new ArrayList<String>();
                // StringBuilder for constructing option1 & option2 sql query
                StringBuilder optionSql = new StringBuilder();
                // if option1 (üsző) is checked
                if(option1.compareTo("on") == 0) {
                    optionSql.append("(sex = 1");
                    // if both option1 and option2 are set
                    if(option2.compareTo("on") == 0) {
                        optionSql.append(" or sex = 0)");
                    }
                    // if option1 is but option2 is not set
                    else {
                        optionSql.append(")");
                    }
                }
                // if option1 (üsző) is not checked
                else {
                    // if option1 isn't but option2 is checked
                    if(option2.compareTo("on") == 0) {
                        optionSql.append("sex = 0");
                    }
                    // if neither options are checked: nothing is appended
                }

                params.add(optionSql.toString());

                // if a specific breed was selected
                if(breed.compareTo("all") != 0) {
                    sql.append("breed = ").append(breed);
                }

                // if a specific type was selected
                if(type.compareTo("all") != 0) {
                    sql.append("type = ").append(type);
                }

                // concat params into a valid sql statement
                switch(params.size()) {
                    case 0:
                        sql.append("id is not null;");
                        break;
                    case 1:
                        for(var param : params) {
                            sql.append(param);
                        }
                        sql.append(";");
                        break;
                    default:
                        for(var param : params) {
                            sql.append(param);
                            sql.append(" and ");
                        }
                        sql.append("id is not null;");
                }
            }
            // if no other value is set
            else {
                sql.append(";");
            }
        }
        // if searchbar is not empty
        else {
            sql.append(" where (id like \"")
                    .append(query)
                    .append("%\" or keeper like \"")
                    .append(query)
                    .append("%\")");

            // if anything else is set
            if(option1.compareTo("on") == 0 || option2.compareTo("on") == 0 || breed.compareTo("all") != 0 || type.compareTo("all") != 0) {
                // list for concatenating sql params into one sql query
                List<String> params = new ArrayList<String>();
                // StringBuilder for constructing option1 & option2 sql query
                StringBuilder optionSql = new StringBuilder();
                // if option1 (üsző) is checked
                if(option1.compareTo("on") == 0) {
                    optionSql.append("(sex = 1");
                    // if both option1 and option2 are set
                    if(option2.compareTo("on") == 0) {
                        optionSql.append(" or sex = 0)");
                    }
                    // if option1 is but option2 is not set
                    else {
                        optionSql.append(")");
                    }
                }
                // if option1 (üsző) is not checked
                else {
                    // if option1 isn't but option2 is checked
                    if(option2.compareTo("on") == 0) {
                        optionSql.append("sex = 0");
                    }
                    // if neither options are checked: nothing is appended
                }

                params.add(optionSql.toString());

                // if a specific breed was selected
                if(breed.compareTo("all") != 0) {
                    sql.append("breed = ").append(breed);
                }

                // if a specific type was selected
                if(type.compareTo("all") != 0) {
                    sql.append("type = ").append(type);
                }

                // concat params into a valid sql statement
                switch(params.size()) {
                    case 0:
                        sql.append("id is not null;");
                        break;
                    case 1:
                        for(var param : params) {
                            sql.append(param);
                        }
                        sql.append(";");
                        break;
                    default:
                        for(var param : params) {
                            sql.append(param);
                            sql.append(" and ");
                        }
                        sql.append("id is not null;");
                }
            }
            // if no other value is set
            else {
                sql.append(";");
            }
        }

        String sqlStatement = sql.toString();
        //List<Animals> animals = (List<Animals>)animalsRepository.findAll();

        List<BreedCodes> breeds = (List<BreedCodes>)breedCodeRepository.findAll();
        List<TypeCodes> types = (List<TypeCodes>)typeCodesRepository.findAll();
        model.addAttribute("breeds", breeds);
        model.addAttribute("types", types);
        model.addAttribute("animals", animals);
        //model.addAttribute("sqlStatement", sqlStatement);
        return "search_interface";
    }
}
