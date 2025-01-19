package com.replaceMe.propertyservice.webapi.mapper;

import com.replaceMe.propertyservice.webapi.entity.PropertyEntity;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import com.replaceMe.propertyservice.webapi.util.CoordinatesFetcher;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PropertyMapper {
    private final CoordinatesFetcher coordinatesFetcher;

    @Autowired
    public PropertyMapper(CoordinatesFetcher coordinatesFetcher) {
        this.coordinatesFetcher = coordinatesFetcher;
    }

    public PropertyEntity toEntity(PropertyRequest request) throws IOException {
        if (request == null) return null;
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setMapsUrl(request.getMaps_url());
        propertyEntity.setLocation(getCoordinatesFromExpandedUrl(request.getMaps_url()));
        propertyEntity.setRent(request.getRent());
        propertyEntity.setDeposit(request.getDeposit());
        propertyEntity.setSet_up_cost(request.getSetUp_cost());
        propertyEntity.setMove_in_date(request.getMove_in_date());
        propertyEntity.setNumberOfBedrooms(request.getNumberOfBedrooms());
        propertyEntity.setGender(request.getGender());
        propertyEntity.setDescription(request.getDescription());
        propertyEntity.setPosted_by(new ObjectId().toString());
        return propertyEntity;

    }
    public PropertyResponse toDto(PropertyEntity entity) {
        if (entity == null) return null;

        GeoJsonPoint location = new GeoJsonPoint(
                entity.getLocation().getX(),
                entity.getLocation().getY()
        );
        PropertyResponse response = new PropertyResponse();
        response.set_id(entity.get_id().toString());
        response.setMaps_url(entity.getMapsUrl());
        response.setLocation(location);
        response.setRent(entity.getRent());
        response.setDeposit(entity.getDeposit());
        response.setSetUp_cost(entity.getSet_up_cost());
        response.setMove_in_date(entity.getMove_in_date());
        response.setNumberOfBedrooms(entity.getNumberOfBedrooms());
        response.setGender(entity.getGender());
        response.setDescription(entity.getDescription());
        response.setPosted_by(entity.getPosted_by());
        return response;
    }

    private GeoJsonPoint getCoordinatesFromExpandedUrl(String shortenedLocationUrl) throws IOException {
        return coordinatesFetcher.extractLocationCoordinates(coordinatesFetcher.expandShortenedUrl(shortenedLocationUrl));
    }

    public void updateEntityFromRequest(PropertyRequest request, PropertyEntity entity) throws IOException {
        if (request.getMaps_url() != null) {
            entity.setMapsUrl(request.getMaps_url());
            entity.setLocation(getCoordinatesFromExpandedUrl(request.getMaps_url()));
        }
        if (request.getMove_in_date() != null) {
            entity.setMove_in_date(request.getMove_in_date());
        }
        entity.setRent(request.getRent());
        entity.setDeposit(request.getDeposit());
        entity.setSet_up_cost(request.getSetUp_cost());
        entity.setNumberOfBedrooms(request.getNumberOfBedrooms());
        entity.setGender(request.getGender());
        entity.setDescription(request.getDescription());


    }
}
