package com.github.fishfly233.accountsystem;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public String register(@RequestBody User user) {
        boolean isCreated = userService.register(user);
        if (isCreated) {
            return "User created successfully!";
        } else {
            return "Error creating user.";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        boolean isValid = userService.login(user);
        if (isValid) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }
}