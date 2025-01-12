package com.replaceMe.propertyservice.webapi.controller;

import com.replaceMe.propertyservice.webapi.exception.ResourceNotFoundException;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import com.replaceMe.propertyservice.webapi.service.PropertyService;
import com.replaceMe.propertyservice.webapi.service.impl.PropertyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/v1")
public class PropertyController {
    PropertyService propertyService;
    PropertyController(PropertyServiceImpl propertyService){
        this.propertyService = propertyService;
    }

    @PostMapping("/property")
    public ResponseEntity<PropertyResponse> addProperty(@RequestBody PropertyRequest request) {
        PropertyResponse response = propertyService.addProperty(request);
        return new ResponseEntity<PropertyResponse>(response, HttpStatus.CREATED); // HTTP 201 with created property
    }

    @GetMapping("/property/{property_id}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable String property_id) throws ResourceNotFoundException {
        PropertyResponse property = propertyService.getProperty(property_id);

        return ResponseEntity.ok(property); // HTTP 200 with the property data
    }

//    @GetMapping("/property")
//    public ResponseEntity<List<PropertyResponse>> getProperties(@ModelAttribute PropertyFilter filter) {
//        List<PropertyEntity> propertyList = propertyService.getProperties(filter);
//
//        return ResponseEntity.ok(property.get()); // HTTP 200 with the property data
//    }

    @PatchMapping("/property/{property_id}")
    public ResponseEntity<PropertyResponse> updateProperty(PropertyRequest request, @PathVariable String property_id) throws ResourceNotFoundException{
        PropertyResponse updatedProperty = propertyService.updateProperty(request, property_id);
        return ResponseEntity.ok(updatedProperty);
    }

    @DeleteMapping("/property/{property_id}")
    public ResponseEntity<PropertyResponse> deleteProperty(@PathVariable String property_id) throws ResourceNotFoundException {
        PropertyResponse deletedProperty = propertyService.deleteProperty(property_id);
        return ResponseEntity.ok(deletedProperty);
    }

}
