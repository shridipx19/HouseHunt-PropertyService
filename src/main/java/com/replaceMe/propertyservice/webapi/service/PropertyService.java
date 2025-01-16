package com.replaceMe.propertyservice.webapi.service;

import com.replaceMe.propertyservice.webapi.exception.ResourceNotFoundException;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;

import java.io.IOException;

public interface PropertyService {

    PropertyResponse addProperty(PropertyRequest request) throws IOException;
    PropertyResponse getProperty(String id) throws ResourceNotFoundException;
//    List<PropertyResponse> getProperties(PropertyFilter filter);
    PropertyResponse updateProperty(PropertyRequest request, String propertyId) throws ResourceNotFoundException, IOException;
    PropertyResponse deleteProperty(String propertyId) throws ResourceNotFoundException;
}

