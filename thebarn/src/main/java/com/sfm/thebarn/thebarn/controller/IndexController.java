package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        HttpSession req = request.getSession(false);
        if (req == null) {
            if (userService.returnList().isEmpty())
            {
                return "redirect:/register";
            }
            return "redirect:/login";
        }
        return "redirect:/csillamfasz";
    }
}
