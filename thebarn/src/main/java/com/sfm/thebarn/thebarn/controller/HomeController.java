package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.UsersCRUD;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/csillamfasz")
    public String showCsillamfaszPage(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        return "csillamfasz";
    }
}