package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Farms;
import com.sfm.thebarn.thebarn.model.FarmsCRUD;
import com.sfm.thebarn.thebarn.model.Users;
import com.sfm.thebarn.thebarn.model.UsersCRUD;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.regex.Pattern;

@Controller
@RequestMapping("/farm-registration")
public class FarmController {

    @Autowired
    private FarmsCRUD farmsCRUD;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersCRUD usersCRUD;

    private static final Pattern FARM_ID_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{5}-\\d{5}$");

    @GetMapping
    public String showRegistrationForm(HttpServletRequest request) {
        HttpSession req = request.getSession(false);
        String username = req.getAttribute("userID").toString();
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        if (usersCRUD.findById(username).get().getFarmId() != null) {
            return "redirect:/";
        }
        return "farm/registration";
    }

    @PostMapping
    public String registerFarm(
            @RequestParam("farmId") String farmId,
            @RequestParam("farmName") String farmName,
            @RequestParam("zipCode") int zipCode,
            @RequestParam("settlement") String settlement,
            @RequestParam("street") String street,
            @RequestParam("streetNumber") int streetNumber,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            RedirectAttributes redirectAttributes) {
        // Tenyészetkód validáció
        if (!FARM_ID_PATTERN.matcher(farmId).matches()) {
            model.addAttribute("errorMessage", "Helytelen tenyészetkód! Helyes formátum: HU-12345-12345");
            return "farm/registration";
        }

        if (farmsCRUD.findById(farmId).isPresent()) {
            model.addAttribute("errorMessage", "A megadott tenyészetkód már létezik!");
            return "farm/registration";
        }
        if (usersCRUD.findById(username).isPresent()) {
            model.addAttribute("errorMessage", "A megadott felhasználónév (e-mail cím) már létezik!");
            return "farm/registration";
        }
        Farms farm = new Farms(farmId, farmName, zipCode, settlement, street, streetNumber);

        farmsCRUD.save(farm);

        usersCRUD.save(new Users(username, DigestUtils.sha256Hex(password),farm));


        return "redirect:/";
    }
}
