package com.sfm.thebarn.thebarn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("/error")
    public String error(){
        return "error_not_coded";
    }
}
