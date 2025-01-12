package com.replaceMe.propertyservice.webapi.repository;

import com.replaceMe.propertyservice.webapi.entity.PropertyEntity;
import com.replaceMe.propertyservice.webapi.exception.ResourceNotFoundException;
import com.replaceMe.propertyservice.webapi.model.request.PropertyFilter;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PropertyRepository extends MongoRepository<PropertyEntity, String> {
    // Spring Data will provide default methods for CRUD
    // Add custom queries if necessary
//    Optional<PropertyEntity> findById(String id);
    // Custom method
    @Query("""
            """)
    List<PropertyEntity> findByFilters(PropertyFilter filter);
}

