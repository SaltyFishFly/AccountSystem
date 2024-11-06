package com.github.fishfly233.accountsystem;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Data
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addUser(User user) {
        var sql =
        """
        INSERT INTO USERS (NAME, PASSWORD)
        VALUES (?, ?)
        """;
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    public List<User> getAllUsers() {
        var sql =
        """
        SELECT * FROM USERS
        """;
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public Optional<User> getUserByUsername(String name) {
        var sql =
        """
        SELECT * FROM USERS WHERE NAME = ?
        """;
        var users = jdbcTemplate.query(sql, new Object[]{name}, new UserRowMapper());
        return users.isEmpty() ? Optional.empty() : Optional.of(users.getFirst());
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("ID"));
            user.setUsername(rs.getString("USERNAME"));
            user.setPassword(rs.getString("PASSWORD"));
            return user;
        }
    }
}
