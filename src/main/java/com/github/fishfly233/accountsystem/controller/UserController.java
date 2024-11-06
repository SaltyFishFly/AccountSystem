package com.github.fishfly233.accountsystem.controller;

import com.github.fishfly233.accountsystem.datamodels.SimpleResponse;
import com.github.fishfly233.accountsystem.datamodels.User;
import com.github.fishfly233.accountsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public SimpleResponse register(@RequestBody User user, HttpSession session) {
        var resp = new SimpleResponse();
        var isSuccess = userService.register(user);
        if (isSuccess) {
            return SimpleResponse.ok();
        } else {
            return SimpleResponse.error();
        }
    }

    @PostMapping("/login")
    public SimpleResponse login(@RequestBody User user, HttpSession session) {
        var val = userService.login(user);
        if (val.isPresent()) {
            session.setAttribute("user", val.get());
            return SimpleResponse.ok();
        } else {
            return SimpleResponse.error();
        }
    }
}