package com.greco.imagetag.repo;

import com.greco.imagetag.model.ObjectKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@JdbcTest
@ComponentScan("com.greco.imagetag")
public class ObjectKeyRepositoryTest {

    @Autowired
    private ObjectKeyRepository objectKeyRepository;

    @Test
    public void addObjectKey() {

        ObjectKey ok = new ObjectKey();
        ok.setBucket("TEST BUCKET");
        ok.setObjectKeyName("TEST NAME");
        assertThat(objectKeyRepository.addObjectKey(ok)).isEqualTo(1);
    }


}