package com.sfm.thebarn.thebarn.controller;

import com.sfm.thebarn.thebarn.model.Users;
import com.sfm.thebarn.thebarn.model.UsersCRUD;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UsersCRUD usersRepository;

    @GetMapping("")
    public String index(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HttpSession req = request.getSession(false);
        if (req == null) {
            return "redirect:/login";
        }
        List<Users> allUsers = (List<Users>) usersRepository.findAll(); //find users
        if (allUsers.isEmpty())
        {
            return "redirect:/register"; //no user redirects to sign up
        }
        return "redirect:/";
    }
}
