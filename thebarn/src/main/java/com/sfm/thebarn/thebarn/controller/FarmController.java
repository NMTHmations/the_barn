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
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/farm-registration")
public class FarmController {

    @Autowired
    private FarmsCRUD farmsCRUD;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersCRUD usersCRUD;

    @GetMapping
    public String showRegistrationForm(HttpServletRequest request) {
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        return "farm/registration";
    }

    @PostMapping
    public String registerFarm(
            @RequestParam(name = "Username") String Id,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "farmId") String farmId,
            @RequestParam(name = "FarmName") String farmName,
            @RequestParam(name = "ZIPCode") int zipCode,
            @RequestParam(name = "Settlement") String settlement,
            @RequestParam(name = "Street") String street,
            @RequestParam(name = "StreetNumber") int streetNumber
    ) {
        Farms farm = new Farms(farmId,farmName, zipCode, settlement, street, streetNumber);

        farmsCRUD.save(farm);

        usersCRUD.save(new Users(Id, DigestUtils.sha256Hex(password),farm));

        return "redirect:/";
    }
}
