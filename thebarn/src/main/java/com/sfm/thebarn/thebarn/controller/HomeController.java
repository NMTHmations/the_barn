package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.UsersCRUD;
import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/csillamfasz")
    public String showCsillamfaszPage(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        if (userService.returnList().isEmpty())
        {
            return "redirect:/register";
        }
        return "csillamfasz";
    }
}