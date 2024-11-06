package com.github.fishfly233.accountsystem.controller;
import com.github.fishfly233.accountsystem.User;
import com.github.fishfly233.accountsystem.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user, HttpSession session) {
        var val = userService.register(user);
        if (val) {
            return "User created successfully!";
        } else {
            return "Error creating user.";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        var val = userService.login(user);
        if (val.isPresent()) {
            session.setAttribute("uid", val.get());
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }
}