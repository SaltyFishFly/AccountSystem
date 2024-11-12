package com.github.fishfly233.accountsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/index")
    public String indexResolver(HttpSession session) {
        if (session.getAttribute("user") == null)
            return "forward:/login";
        else
            return "forward:/sql";
    }

    @GetMapping("/login")
    public String loginSolver() {
        return "login";
    }

    @GetMapping("/sql")
    public String sqlResolver(HttpSession session) {
        if (session.getAttribute("user") == null)
            return "forward:/login";
        else
            return "sql";
    }
}
