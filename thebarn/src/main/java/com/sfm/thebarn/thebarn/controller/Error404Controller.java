package com.sfm.thebarn.thebarn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Error404Controller {
    @GetMapping("/error404")
    public String error404() {
        return "error404";
    }
}
