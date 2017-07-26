package com.greco.imagetag.repo;


import com.greco.imagetag.model.DetectedLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DetectedLabelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addDetectedLabel(DetectedLabel detectedLabel){
        return jdbcTemplate.update("INSERT INTO labels(labelname) VALUES (?)",
                detectedLabel.getLabelName());
    }

}
