package com.replaceMe.propertyservice.webapi.mapper;

import com.replaceMe.propertyservice.webapi.entity.PropertyEntity;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {
     public static PropertyEntity toEntity(PropertyRequest request) {
         if (request == null) return null;
         PropertyEntity propertyEntity = new PropertyEntity();
             propertyEntity.setMapsUrl("https://maps.app.goo.gl/GXR8NGbbA6Hn1nrQ6");
             propertyEntity.setLocation(extractCoordinates("https://maps.app.goo.gl/GXR8NGbbA6Hn1nrQ6"));
             propertyEntity.setRent(request.getRent());
             propertyEntity.setDeposit(request.getDeposit());
             propertyEntity.setSetupCost(request.getSetUpCost());
             propertyEntity.setMoveInDate(request.getMoveInDate());
             propertyEntity.setNumberOfBedrooms(request.getNumberOfBedrooms());
             propertyEntity.setGender(request.getGender());
             propertyEntity.setDescription(request.getDescription());
             propertyEntity.setPostedBy(new ObjectId().toString());
         return propertyEntity;

     }

     // DTO to Entity
     public static PropertyResponse toDto(PropertyEntity entity) {
         if (entity == null) return null;

         GeoJsonPoint location = new GeoJsonPoint(
                 entity.getLocation().getX(),
                 entity.getLocation().getY()
         );
         PropertyResponse response = new PropertyResponse();
             response.setId(entity.getId());
             response.setMapsUrl("https://maps.app.goo.gl/GXR8NGbbA6Hn1nrQ6");
             response.setLocation(location);
             response.setRent(entity.getRent());
             response.setDeposit(entity.getDeposit());
             response.setSetUpCost(entity.getSetupCost());
             response.setMoveInDate(entity.getMoveInDate());
             response.setNumberOfBedrooms(entity.getNumberOfBedrooms());
             response.setGender(entity.getGender());
             response.setDescription(entity.getDescription());
             response.setPostedBy(entity.getPostedBy());
         return response;
     }
    public static GeoJsonPoint extractCoordinates(String mapsUrl) {
        // Example: Call Google Maps API to resolve short URL and get coordinates
        // This is just a placeholder; actual implementation requires API integration.
        double latitude = 40.782865; // Example latitude
        double longitude = -73.965355; // Example longitude
        return new GeoJsonPoint(longitude, latitude);
    }

}
