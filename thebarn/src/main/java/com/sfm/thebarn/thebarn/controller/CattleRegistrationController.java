package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class CattleRegistrationController {

    @Autowired
    private FarmsCRUD farmsRepository;

    @Autowired
    private AnimalsCRUD animalsRepository;

    @Autowired
    private BreedCodeCRUD breedCodeRepository;

    @Autowired
    private ColourCodesCRUD colourCodesRepository;

    @Autowired
    private TypeCodesCRUD typeCodesRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/cattle_registration")
    public String showCattleRegistration(HttpServletRequest request) {
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        return "cattle_registration";
    }

    @PostMapping("/cattle_registration")
    public String cattleRegistration(@RequestParam String selfId, @RequestParam String sex, @RequestParam String breed, @RequestParam String type, @RequestParam String colour, @RequestParam String birthDate, @RequestParam String motherId, @RequestParam String fatherId, @RequestParam String holdingId, Model model) {

        if (selfId.equals("-")) //if self id is "-"
        {
            model.addAttribute("CDerror", "Érvénytelen saját azonosító!"); // make cattle data error message visible
            return "cattle_registration"; // stay on cattle registration
        }

        Animals self = animalsRepository.findById(selfId).orElse(null); //find submitted self id
        if (self != null) //if self id already exists
        {
            model.addAttribute("SIerror", "Már létezik marha ilyen azonosítóval!"); // make self id error message visible
            return "cattle_registration"; // stay on cattle registration
        }

        Farms farm = farmsRepository.findById(holdingId).orElse(null); //find submitted holding code
        if (farm == null) //if holding code doesn't exist
        {
            model.addAttribute("HCerror", "Nem létező tenyészet kódját adta meg!"); // make holding code error message visible
            return "cattle_registration"; // stay on cattle registration
        }

        Animals mother = animalsRepository.findById(motherId).orElse(null); //find submitted mother id
        if (!motherId.isBlank()) // if left empty, skip
        {
            if (mother == null || mother.getSex()) //if mother id doesn't exist or a male
            {
                model.addAttribute("MIerror", "Nem létező Anya azonosító!<br>(előbb hozza létre az Anya marhát vagy hagyja üresen)"); // make mother id error message visible
                return "cattle_registration"; // stay on cattle registration
            }
        }

        Animals father = animalsRepository.findById(fatherId).orElse(null); //find submitted father id
        if (!fatherId.isBlank()) //if not empty then skip
        {
            if (father == null || !father.getSex()) //if father id doesn't exist or a female
            {
                model.addAttribute("FIerror", "Nem létező Apa azonosító!<br>(előbb hozza létre az Apa marhát vagy hagyja üresen)"); // make father id error message visible
                return "cattle_registration"; // stay on cattle registration
            }
        }

        Boolean zex = Boolean.valueOf(sex); // convert sex string to zex boolean
        BreedCodes breedCode = breedCodeRepository.findById(Integer.parseInt(breed)).orElse(null); // find submitted breed code
        ColourCodes colourCode = colourCodesRepository.findById(Integer.parseInt(colour)).orElse(null); // find submitted color code
        TypeCodes typeCode = typeCodesRepository.findById(Integer.parseInt(type)).orElse(null); // find submitted type code

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // set format to "yyyy-MM-dd"
            java.util.Date utilDate = format.parse(birthDate); // String --> java.util.date
            Date sqlBirthDate = new Date(utilDate.getTime()); // java.util.date --> java.sql.Date

            Animals animal = new Animals(selfId, zex, father, mother, farm, sqlBirthDate, colourCode, breedCode, typeCode); //creating animal
            animalsRepository.save(animal); // saving animal
        }
        catch (ParseException e) {
            model.addAttribute("Derror", "Dátum formázási hiba, adatok nincsenek mentve!"); // make date error message visible
            return "cattle_registration";
        }

        //return "search_interface";
        return "redirect:/"; //maybe the other return is enough once there is actually a page like that
    }
}
