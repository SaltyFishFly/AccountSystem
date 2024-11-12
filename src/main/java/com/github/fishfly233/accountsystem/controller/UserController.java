package com.github.fishfly233.accountsystem.controller;

import com.github.fishfly233.accountsystem.datamodels.SimpleResponse;
import com.github.fishfly233.accountsystem.datamodels.User;
import com.github.fishfly233.accountsystem.exception.UserExistsException;
import com.github.fishfly233.accountsystem.exception.UserNotExistsException;
import com.github.fishfly233.accountsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseBody
    public SimpleResponse register(@RequestBody User user, HttpSession session) {
        try {
            userService.register(user);
            return SimpleResponse.ok();
        }
        catch (UserExistsException e) {
            return SimpleResponse.error("用户已经存在");
        }
        catch (Exception e) {
            return SimpleResponse.error("未知内部错误");
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public SimpleResponse login(@RequestBody User user, HttpSession session) {
        try {
            var val = userService.login(user);
            session.setAttribute("user", val);
            return SimpleResponse.ok();
        }
        catch (UserNotExistsException e) {
            return SimpleResponse.error("用户不存在");
        }
        catch (Exception e) {
            return SimpleResponse.error("未知内部错误");
        }
    }
}