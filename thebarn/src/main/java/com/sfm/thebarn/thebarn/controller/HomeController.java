package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.UsersCRUD;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/csillamfasz")
    public String showCsillamfaszPage() {
        return "csillamfasz";
    }
}