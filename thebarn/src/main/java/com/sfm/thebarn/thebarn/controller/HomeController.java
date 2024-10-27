package com.sfm.thebarn.thebarn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/csillamfasz")
    public String showCsillamfaszPage() {
        return "csillamfasz";
    }
}