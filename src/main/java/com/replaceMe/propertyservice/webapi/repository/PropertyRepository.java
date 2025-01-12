package com.replaceMe.propertyservice.webapi.repository;

import com.replaceMe.propertyservice.webapi.entity.PropertyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepository extends MongoRepository<PropertyEntity, String> {
}

