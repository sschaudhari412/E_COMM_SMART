package com.ecomsmart.backend.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/db-test")
    public String testDbConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Database is connected!";
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}

