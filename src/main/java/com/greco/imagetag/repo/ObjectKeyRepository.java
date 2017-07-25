package com.greco.imagetag.repo;


import com.greco.imagetag.model.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ObjectKeyRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addObjectKey(ObjectKey objectKey) {

        jdbcTemplate.update("INSERT INTO images(bucket, objectkey, objectkeysha1) VALUES (?,?,?)",
                objectKey.getBucket(), objectKey.getObjectKeyName(), objectKey.getObjectKeySha1());

    }

}
