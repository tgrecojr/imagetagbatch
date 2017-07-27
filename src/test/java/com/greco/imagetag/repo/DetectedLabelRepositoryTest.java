package com.greco.imagetag.repo;

import com.greco.imagetag.model.DetectedLabel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@JdbcTest
@ComponentScan("com.greco.imagetag")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DetectedLabelRepositoryTest {

    @Autowired
    private DetectedLabelRepository detectedLabelRepository;

    @Test
    public void addDetectedLabel() {

        DetectedLabel dl = buildDetectedLabel();
        assertThat(detectedLabelRepository.addDetectedLabel(dl)).isEqualTo(1);
    }

    private DetectedLabel buildDetectedLabel(){
        DetectedLabel dl = new DetectedLabel();
        dl.setLabelName("TEST LABEL");
        return dl;
    }

}