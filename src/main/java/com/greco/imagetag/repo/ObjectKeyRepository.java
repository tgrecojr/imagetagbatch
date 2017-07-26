package com.greco.imagetag.repo;


import com.greco.imagetag.model.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ObjectKeyRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addObjectKey(ObjectKey objectKey) {

        return jdbcTemplate.update("INSERT INTO images(bucket, objectkey, objectkeysha1) VALUES (?,?,?)",
                objectKey.getBucket(), objectKey.getObjectKeyName(), objectKey.getObjectKeySha1());

    }

    @Cacheable("objectkeys")
    public List<ObjectKey> findAll() {

        List<ObjectKey> result = jdbcTemplate.query(
                "SELECT id,bucket, objectkey FROM images",
                (rs, rowNum) -> new ObjectKey(rs.getInt("id"), rs.getString("bucket"), rs.getString("objectkey"))
        );

        return result;

    }

    @Cacheable("objectkey")
    public ObjectKey findObjectKey(String bucket, String objectKey){
        return jdbcTemplate.queryForObject(
                "select id, bucket, objectkey from images where bucket = '" + bucket + "' and objectkey = '" + objectKey +"'",
                (rs, i) -> new ObjectKey(rs.getInt("id"), rs.getString("bucket"), rs.getString("objectkey")));
    }


}
