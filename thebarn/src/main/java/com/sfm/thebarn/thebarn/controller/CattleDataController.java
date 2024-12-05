package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CattleDataController {

    @Autowired
    private AnimalsCRUD animalsRepository;

    @Autowired
    private FarmsCRUD farmsRepository;

    @Autowired
    private UsersCRUD usersRepository;

    @GetMapping("/cattle-data/{id}")
    public String showCattleData(@PathVariable String id, Model model, HttpServletRequest request) {

        HttpSession current = request.getSession(false); // get current session
        if (current == null) { // if there is  no session
            return "redirect:/login"; // redirect to login
        }

        Users user = usersRepository.findById((String) current.getAttribute("userid")).orElse(null); // get user from session
        if (user == null) // if user doesn't exists
        {
            current.invalidate(); // end session
            return "redirect:/login"; // redirect to login
        }

        Animals animal = animalsRepository.findById(id).orElse(null); // find animal by url
        if (animal == null) {
            return "redirect:/error404";
        }

        Farms farm = farmsRepository.findById(animal.getFarmid()).orElse(null); // find farm
        if (farm == null) {
            return "redirect:/error404";
        }

        if (user.getFarmId() != null) // if user is not admin
        {
            if (!user.getFarmId().equals(animal.getFarmid())) // if user doesn't own animal
            {
                current.invalidate(); // end session
                return "redirect:/login"; // redirect to login
            }
        }

        model.addAttribute("id", animal.getId()); // give back data: id
        if(animal.getSex()) {
            model.addAttribute("sex", "hímivar (bika) [Male]"); // give back data: if sex male
        }
        else{
            model.addAttribute("sex", "nőivar (üsző) [Female]"); // give back data: if sex female
        }
        model.addAttribute("breed", animal.getBreed()); // give back data: breed
        model.addAttribute("type", animal.getType()); // give back data: type
        model.addAttribute("colour", animal.getColor()); // give back data: colour
        model.addAttribute("birthDate", animal.getBirthDate()); // give back data: birthdate
        if(animal.getDeathDate() == null) {
            model.addAttribute("deathDate", "-"); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("deathDate", animal.getDeathDate()); // give back data: death date (if exits)
        }

        if(animal.getPrevId() == null) {
            model.addAttribute("prevId", "-"); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("prevId", animal.getPrevId()); // give back data: previous id (if exits)
        }

        if(animal.getMotherId() == null) {

            model.addAttribute("motherId", "-"); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("motherId", animal.getMotherId()); // give back data: mother id (if exits)
        }

        if(animal.getFatherId() == null) {
            model.addAttribute("fatherId", "-"); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("fatherId", animal.getFatherId()); // give back data: father id (if exits)
        }
        model.addAttribute("farmName", farm.getFarmName()); // give back data: farm name
        model.addAttribute("farmId", animal.getFarmid()); // give back data: farm id
        model.addAttribute("ZIPCode", String.valueOf(farm.getZIPCode())); // give back data: zip code
        model.addAttribute("settlement", farm.getSettlement()); // give back data: settlement
        model.addAttribute("street", farm.getStreet()); // give back data: street
        model.addAttribute("streetNumber", farm.getStreetNumber()); // give back data: street number

        List<Animals> offsprings = new ArrayList<Animals>(); // avoiding null pointer exception
        if(animal.getSex()) // if male
        {
            offsprings = (List<Animals>) animalsRepository.findByfatherid(animal); // find offsprings
        }

        else // if female
        {
            offsprings = (List<Animals>) animalsRepository.findBymotherid(animal); // find offsprings
        }

        List<String> offspringId = offsprings.stream()
                                              .map(Animals::getId)
                                              .toList(); // get id of offsprings

        if(offspringId.isEmpty()) {
            List<String> zero = List.of("-");
            model.addAttribute("offspringsIds", zero); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("offspringsIds", offspringId); // give back data: offsprings (if exits)
        }
        return "cattle-data";
    }
}
