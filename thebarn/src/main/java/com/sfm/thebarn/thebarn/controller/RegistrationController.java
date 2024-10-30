package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Users;
import com.sfm.thebarn.thebarn.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        if (userService.userExists(email)) {
            model.addAttribute("error", "Ez az e-mail cím már regisztrálva van.");
            return "registration";
        }
        userService.registerUser(new Users(email, DigestUtils.sha256Hex(password), null));
        return "redirect:/login";
    }
}
