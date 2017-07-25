package com.greco.imagetag.repo;


import com.greco.imagetag.model.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectKeyRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addObjectKey(ObjectKey objectKey) {

        return jdbcTemplate.update("INSERT INTO images(bucket, objectkey, objectkeysha1) VALUES (?,?,?)",
                objectKey.getBucket(), objectKey.getObjectKeyName(), objectKey.getObjectKeySha1());

    }

    public List<ObjectKey> findAll() {

        List<ObjectKey> result = jdbcTemplate.query(
                "SELECT bucket, objectkey FROM images",
                (rs, rowNum) -> new ObjectKey(rs.getInt("id"), rs.getString("bucket"), rs.getString("objectkey"))
        );

        return result;

    }

}
