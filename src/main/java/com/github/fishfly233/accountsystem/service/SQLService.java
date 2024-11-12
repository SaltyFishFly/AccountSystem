package com.github.fishfly233.accountsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SQLService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SQLService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeSQL(String sql) throws DataAccessException {
        jdbcTemplate.execute(sql);
    }
}
