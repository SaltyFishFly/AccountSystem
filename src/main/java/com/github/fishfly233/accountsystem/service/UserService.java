package com.github.fishfly233.accountsystem.service;

import com.github.fishfly233.accountsystem.dao.UserDao;
import com.github.fishfly233.accountsystem.datamodels.User;
import com.github.fishfly233.accountsystem.exception.UserExistsException;
import com.github.fishfly233.accountsystem.exception.UserNotExistsException;
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

    public void register(User user) throws UserExistsException {
        var record = userDao.getUserByUsername(user.getUsername());
        if (record.isEmpty()) userDao.addUser(user);
        else throw new UserExistsException();
    }

    public User login(User user) throws UserNotExistsException {
        var record = userDao.getUserByUsername(user.getUsername());
        if (record.isEmpty()) throw new UserNotExistsException();
        return record.get();
    }
}
