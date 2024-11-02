package com.sfm.thebarn.thebarn.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSessionController {
    @GetMapping("login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "redirect:/";
    }
}
