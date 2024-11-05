package com.github.fishfly233.accountsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {

    JdbcTemplate jdbcTemplate;

    private static final String CREATE_ACCOUNT_TABLE =
    """
    CREATE TABLE ACCOUNT IF NOT EXISTS (
        ID INTEGER PRIMARY KEY AUTOINCREMENT,
        NAME VARCHAR(255),
        PASSWORD VARCHAR(255)
    );
    """;

    @Autowired
    public DbInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute(CREATE_ACCOUNT_TABLE);
    }
}
