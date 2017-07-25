package com.greco.imagetag.repo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DetectedLabelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
