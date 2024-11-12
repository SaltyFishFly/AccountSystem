package com.github.fishfly233.accountsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {

    JdbcTemplate jdbcTemplate;

    private static final String CREATE_USERS_TABLE =
    """
    CREATE TABLE IF NOT EXISTS USERS (
        ID INTEGER PRIMARY KEY AUTO_INCREMENT,
        USERNAME VARCHAR(255) NOT NULL UNIQUE,
        PASSWORD VARCHAR(255) NOT NULL
    );
    """;

    @Autowired
    public DbInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute(CREATE_USERS_TABLE);
    }
}
