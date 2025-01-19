package com.replaceMe.propertyservice.webapi.controller;

import com.replaceMe.propertyservice.webapi.exception.ResourceNotFoundException;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import com.replaceMe.propertyservice.webapi.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/property")
    public ResponseEntity<PropertyResponse> addProperty(@RequestBody PropertyRequest request) throws IOException {
        PropertyResponse response = propertyService.addProperty(request);
        return new ResponseEntity<PropertyResponse>(response, HttpStatus.CREATED); // HTTP 201 with created property
    }

    @GetMapping("/property/{property_id}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable String property_id) throws ResourceNotFoundException {
        PropertyResponse property = propertyService.getProperty(property_id);

        return ResponseEntity.ok(property); // HTTP 200 with the property data
    }
    @PatchMapping("/property/{property_id}")
    public ResponseEntity<PropertyResponse> updateProperty(@RequestBody PropertyRequest request, @PathVariable String property_id) throws ResourceNotFoundException, IOException {
        PropertyResponse updatedProperty = propertyService.updateProperty(request, property_id);
        return ResponseEntity.ok(updatedProperty);
    }

    @DeleteMapping("/property/{property_id}")
    public ResponseEntity<PropertyResponse> deleteProperty(@PathVariable String property_id) throws ResourceNotFoundException {
        PropertyResponse deletedProperty = propertyService.deleteProperty(property_id);
        return ResponseEntity.ok(deletedProperty);
    }
}
