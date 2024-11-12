package com.github.fishfly233.accountsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String indexResolver() {
        return "index";
    }
}
