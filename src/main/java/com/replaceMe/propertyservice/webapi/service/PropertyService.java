package com.replaceMe.propertyservice.webapi.service;

import com.replaceMe.propertyservice.webapi.exception.ResourceNotFoundException;
import com.replaceMe.propertyservice.webapi.model.request.PropertyFilter;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    PropertyResponse addProperty(PropertyRequest request);
    PropertyResponse getProperty(String id) throws ResourceNotFoundException;
//    List<PropertyResponse> getProperties(PropertyFilter filter);
    PropertyResponse updateProperty(PropertyRequest request, String propertyId) throws ResourceNotFoundException;
    PropertyResponse deleteProperty(String propertyId) throws ResourceNotFoundException;
}

