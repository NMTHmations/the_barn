package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Users;
import com.sfm.thebarn.thebarn.model.UsersCRUD;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UsersCRUD usersRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            return "redirect:/";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String Email, @RequestParam String Password, Model model, HttpServletRequest request) {
        Users user = usersRepository.findById(Email).orElse(null); //find submitted username
        if (user != null && user.getPasswd().equals(DigestUtils.sha256Hex(Password))) //if password match
        {
            request.getSession().setAttribute(user.getId(), user.getId());
            return "redirect:/csillamfasz"; //redirect to home page
        }
        model.addAttribute("error", "Rossz e-mail és/vagy jelszó!"); // if password mismatch make error message visible
        return "login"; //and stay on login
    }
}