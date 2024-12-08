package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class CattleEditController {

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
    private UsersCRUD usersRepository;

    @GetMapping("/cattle_edit/{id}")
    public String showCattleRegistration(@ModelAttribute("error") String error, @ModelAttribute("HCinput") String HCinput, @PathVariable String id, HttpServletRequest request, Model model)
    {
        HttpSession current = request.getSession(false); // get current session
        if (current == null) { // if there is  no session
            return "redirect:/login"; // redirect to login
        }

        Users user = usersRepository.findById((String) current.getAttribute("userID")).orElse(null); // get user from session
        if (user == null) // if user doesn't exists
        {
            current.invalidate(); // end session
            return "redirect:/login"; // redirect to login
        }

        Animals animal = animalsRepository.findById(id).orElse(null); // find animal by url
        if (animal == null) {
            return "redirect:/error404";
        }

        if (user.getFarmId() != null) // if user is not admin
        {
            if (!user.getFarmId().equals(animal.getFarmid())) // if user doesn't own animal
            {
                current.invalidate(); // end session
                return "redirect:/login"; // redirect to login
            }
            model.addAttribute("HCinput", null);
        }
        else // if user is admin
        {
            model.addAttribute("HCinput", true); // make holding code input visible
            model.addAttribute("animalHoldingCode", animal.getFarmid().getId()); // give back holding code value
        }

        if (error != null) {
            model.addAttribute("error", error); // Add the error message
        }

        if (HCinput != null && HCinput.equals("true")) {
            model.addAttribute("HCinput", true); // Add the animal ID
        }

        // give back data of current animal*
        model.addAttribute("animalId", animal.getId());
        model.addAttribute("animalSex", animal.getSex());
        model.addAttribute("animalBreed", animal.getBreed().getId());
        model.addAttribute("animalColor", animal.getColor().getId());
        model.addAttribute("animalType", animal.getType().getId());
        model.addAttribute("animalBirthDate", animal.getBirthDate());
        if(animal.getDeathDate() == null) {
            model.addAttribute("animalDeathDate", ""); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("animalDeathDate", animal.getDeathDate()); // give back data: death date (if exits)
        }

        if(animal.getPrevId() == null) {
            model.addAttribute("animalPrevId", ""); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("animalPrevId", animal.getPrevId()); // give back data: previous id (if exits)
        }

        if(animal.getMotherid() == null) {

            model.addAttribute("animalMotherId", ""); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("animalMotherId", animal.getMotherid().getId()); // give back data: mother id (if exits)
        }

        if(animal.getFatherid() == null) {
            model.addAttribute("animalFatherId", ""); // give back data: "-" (if doesn't exits)
        }
        else{
            model.addAttribute("animalFatherId", animal.getFatherid().getId()); // give back data: father id (if exits)
        }
        // give back data of current animal*

         return "cattle_edit"; // stay on cattle edit
    }

    @PostMapping("/cattle_edit/{id}")
    public String cattleRegistration(RedirectAttributes redirectAttributes, @PathVariable String id, HttpServletRequest request, @RequestParam String sex, @RequestParam String breed, @RequestParam String type, @RequestParam String colour, @RequestParam String birthDate, @RequestParam String deathDate, @RequestParam String previousId, @RequestParam String motherId, @RequestParam String fatherId, @RequestParam(required = false) String holdingId, Model model) {

        HttpSession current = request.getSession(false); // get current session
        if (current == null) { // if there is  no session
            return "redirect:/login"; // redirect to login
        }

        Users user = usersRepository.findById((String) current.getAttribute("userID")).orElse(null); // get user from session
        if (user == null) // if user doesn't exists
        {
            current.invalidate(); // end session
            return "redirect:/login"; // redirect to login
        }

        Animals animal = animalsRepository.findById(id).orElse(null); // find animal by url
        if (animal == null) { // if not found
            return "redirect:/error404"; // show 404 error
        }

        Farms farm;
        if (user.getFarmId() == null) // if user is admin
        {
            farm = farmsRepository.findById(holdingId).orElse(null); // find submitted holding code
            if (farm == null) // if holding code doesn't exist
            {
                redirectAttributes.addFlashAttribute("error", "Nem létező tenyészet kódját adta meg!"); // make holding code error message visible
                redirectAttributes.addFlashAttribute("HCinput", "true"); // make holding code input visible
                return "redirect:/cattle_edit/" + id; // stay on cattle edit
            }
        }
        else
        {
            farm = farmsRepository.findById(user.getFarmId().getId()).orElse(null); // find user's holding code
        }


        Animals mother = animalsRepository.findById(motherId).orElse(null); //find submitted mother id
        if (!motherId.isBlank()) // if left empty, skip
        {
            if (mother == null || mother.getSex()) //if mother id doesn't exist or a male
            {
                redirectAttributes.addFlashAttribute("error", "Nem létező Anya azonosító!<br>(előbb hozza létre az Anya marhát vagy hagyja üresen)"); // make mother id error message visible
                if (user.getFarmId() == null){ // if user is admin
                    redirectAttributes.addFlashAttribute("HCinput", "true"); // make holding code input visible
                }
                else{
                    redirectAttributes.addFlashAttribute("HCinput", "false");
                }
                return "redirect:/cattle_edit/" + id; // stay on cattle edit
            }
        }

        Animals father = animalsRepository.findById(fatherId).orElse(null); //find submitted father id
        if (!fatherId.isBlank()) //if empty skip
        {
            if (father == null || !father.getSex()) // if father id doesn't exist or a female
            {
                redirectAttributes.addFlashAttribute("error", "Nem létező Apa azonosító!<br>(előbb hozza létre az Apa marhát vagy hagyja üresen)"); // make father id error message visible
                if (user.getFarmId() == null){ // if user is admin
                    redirectAttributes.addFlashAttribute("HCinput", "true"); // make holding code input visible
                }
                else{
                    redirectAttributes.addFlashAttribute("HCinput", "false");
                }
                return "redirect:/cattle_edit/" + id; // stay on cattle edit
            }
        }

        Boolean zex = Boolean.valueOf(sex); // convert sex string to zex boolean
        BreedCodes breedCode = breedCodeRepository.findById(Integer.parseInt(breed)).orElse(null); // find submitted breed code
        ColourCodes colourCode = colourCodesRepository.findById(Integer.parseInt(colour)).orElse(null); // find submitted color code
        TypeCodes typeCode = typeCodesRepository.findById(Integer.parseInt(type)).orElse(null); // find submitted type code

        Date sqlBirthDate;
        Date sqlDeathDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // set format to "yyyy-MM-dd"
        try {
            java.util.Date utilDate = format.parse(birthDate); // String --> java.util.date
            sqlBirthDate = new Date(utilDate.getTime()); // java.util.date --> java.sql.Date


            if (!deathDate.isBlank()) //if empty skip
            {
                utilDate = format.parse(birthDate); // String --> java.util.date
                sqlDeathDate = new Date(utilDate.getTime()); // java.util.date --> java.sql.Date
            }

        }
        catch (ParseException e) {
            redirectAttributes.addFlashAttribute("error", "Dátum formázási hiba, adatok nincsenek mentve!"); // make date error message visible
            if (user.getFarmId() == null){ // if user is admin
                redirectAttributes.addFlashAttribute("HCinput", "true"); // make holding code input visible
            }
            else{
                redirectAttributes.addFlashAttribute("HCinput", "false");
            }
            return "redirect:/cattle_edit/" + id; // stay on cattle edit
        }

        try {
            //setting values*
            animal.setSex(zex);
            animal.setFatherid(father);
            animal.setMotherid(mother);
            animal.setFarmid(farm);
            animal.setBirthDate(sqlBirthDate);
            animal.setDeathDate(sqlDeathDate);
            animal.setPrevId(previousId);
            animal.setColor(colourCode);
            animal.setBreed(breedCode);
            animal.setType(typeCode);
            //setting values*
            animalsRepository.save(animal); // saving animal
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "A mentési folyamat megszakadt, adatok nincsenek mentve!"); // make date error message visible
            if (user.getFarmId() == null){ // if user is admin
                redirectAttributes.addFlashAttribute("HCinput", "true"); // make holding code input visible
            }
            else{
                redirectAttributes.addFlashAttribute("HCinput", "false");
            }
            return "redirect:/cattle_edit/" + id; // stay on cattle edit
        }

        return "redirect:/cattle-data/" + id;
    }
}
