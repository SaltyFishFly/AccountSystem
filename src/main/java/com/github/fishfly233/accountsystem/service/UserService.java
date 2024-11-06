package com.github.fishfly233.accountsystem.service;

import com.github.fishfly233.accountsystem.dao.UserDao;
import com.github.fishfly233.accountsystem.datamodels.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean register(User user) {
        return userDao.addUser(user) != 0;
    }

    public Optional<User> login(User user) {
        return userDao.getUserByUsername(user.getUsername());
    }
}
