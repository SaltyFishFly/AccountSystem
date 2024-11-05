package com.github.fishfly233.accountsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User register(String username, String password) {
        return new User();
    }

    public User login(String username, String password) {
        return new User();
    }
}
