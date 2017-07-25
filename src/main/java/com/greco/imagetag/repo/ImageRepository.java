package com.greco.imagetag.repo;

import com.greco.imagetag.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long>{
}
