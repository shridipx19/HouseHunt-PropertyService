package com.replaceMe.propertyservice.webapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDate;

@Getter
@Setter
public class PropertyResponse {
    private String id;
    private String mapsUrl;
    private GeoJsonPoint location;
    private int rent;
    private int deposit;
    private int setUpCost;
    private String moveInDate;
    private int numberOfBedrooms;
    private String gender;
    private String description;
    private String postedBy;
}
