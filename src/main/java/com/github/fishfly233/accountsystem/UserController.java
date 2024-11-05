package com.github.fishfly233.accountsystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @PostMapping(path = "/api/login")
    public String createUser(@RequestBody User user) {
        return "";
    }
}
