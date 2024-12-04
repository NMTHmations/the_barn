package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Users;
import com.sfm.thebarn.thebarn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    private static final String STRONG_PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";

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
            model.addAttribute("attempted", true); // Jelzi, hogy próbálkoztunk
            return "registration";
        }

        if (!isStrongPassword(password)) {
            model.addAttribute("error", "A jelszónak minimum 8 karakter hosszúnak kell lennie, tartalmaznia kell legalább egy nagybetűt, egy számot és egy speciális karaktert.");
            model.addAttribute("attempted", true); // Jelzi, hogy próbálkoztunk
            return "registration";
        }

        userService.registerUser(new Users(email, password, null));
        return "redirect:/login";
    }

    private boolean isStrongPassword(String password) {
        return Pattern.matches(STRONG_PASSWORD_REGEX, password);
    }
}
