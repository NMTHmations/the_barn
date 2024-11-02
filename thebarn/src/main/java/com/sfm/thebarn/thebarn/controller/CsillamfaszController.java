package com.sfm.thebarn.thebarn.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsillamfaszController {
    @GetMapping("")
    public String index(Model model, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/logout";
        }
        /*
        if (req.getCreationTime()+req.getMaxInactiveInterval() < req.getLastAccessedTime())
        {
            req.invalidate();
            return "redirect:/logout";
        }*/
        return "csillamfasz";
    }
}
