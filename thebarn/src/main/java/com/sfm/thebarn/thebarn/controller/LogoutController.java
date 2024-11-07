package com.sfm.thebarn.thebarn.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("logout")
    public String showLogout(HttpServletRequest request) {
        HttpSession req = request.getSession(false);
        if (req != null) {
            req.invalidate();
        }
        return "redirect:/";
    }
}
