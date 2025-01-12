package com.replaceMe.propertyservice.webapi.service.impl;

import com.replaceMe.propertyservice.webapi.entity.PropertyEntity;
import com.replaceMe.propertyservice.webapi.exception.ResourceNotFoundException;
import com.replaceMe.propertyservice.webapi.exception.ValidationException;
import com.replaceMe.propertyservice.webapi.mapper.PropertyMapper;
import com.replaceMe.propertyservice.webapi.model.request.PropertyFilter;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import com.replaceMe.propertyservice.webapi.repository.PropertyRepository;
import com.replaceMe.propertyservice.webapi.service.PropertyService;
import com.replaceMe.propertyservice.webapi.util.Constants;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyMapper propertyMapper;

    private final PropertyRepository propertyRepository;
    private final MongoTemplate mongoTemplate;

    public PropertyServiceImpl(PropertyRepository propertyRepository, MongoTemplate mongoTemplate) {
        this.propertyRepository = propertyRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PropertyResponse addProperty(PropertyRequest request) {
        validateRequest(request);
        PropertyEntity propertyEntity = propertyMapper.toEntity(request);
        PropertyEntity savedEntity = propertyRepository.save(propertyEntity);
        return propertyMapper.toDto(savedEntity);
    }
    @Override
    public PropertyResponse getProperty(String propertyId) throws ResourceNotFoundException {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);
        if(propertyEntity.isEmpty()) {
            throw new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND);
        }
        return propertyMapper.toDto(propertyEntity.get());
    }
    @Override
    public List<PropertyResponse> getProperties(PropertyFilter filter) {
        List<PropertyEntity> propertyEntityList = propertyRepository.findByFilters(filter);
        return propertyEntityList.stream()
                .map(propertyMapper::toDto).toList();
    }
    @Override
    public PropertyResponse updateProperty(PropertyRequest request, String propertyId) throws ResourceNotFoundException {
        validateRequest(request);
        PropertyEntity propertyEntity = propertyMapper.toEntity(request);
        PropertyEntity savedEntity = propertyRepository.save(propertyEntity);
        return propertyMapper.toDto(savedEntity);
    }

    @Override
    public PropertyResponse deleteProperty(String propertyId) throws ResourceNotFoundException {
        Optional<PropertyEntity> deletedEntity = propertyRepository.findById(propertyId);
        if (deletedEntity.isEmpty()) throw new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND);
        propertyRepository.deleteById(propertyId);
        return propertyMapper.toDto(deletedEntity.get());
    }

    private void validateRequest(PropertyRequest request) throws ValidationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            StringBuilder errorMessages = new StringBuilder();
            for (ConstraintViolation<PropertyRequest> violation : violations) {
                errorMessages.append(violation.getMessage()).append("\n");
            }
            throw new ValidationException(Constants.INVALID_REQUEST, errorMessages.toString());
        }
    }

    private void checkIfPropertyExists(String propertyId) throws ResourceNotFoundException {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);
        if(propertyEntity.isEmpty()) {
            throw new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND);
        }
    }
}

