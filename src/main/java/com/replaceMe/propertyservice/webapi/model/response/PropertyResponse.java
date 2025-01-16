package com.replaceMe.propertyservice.webapi.model.response;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDate;

@Getter
@Setter
public class PropertyResponse {
    private String _id;
    private String maps_url;
    private GeoJsonPoint location;
    private int rent;
    private int deposit;
    private int setUp_cost;
    private LocalDate move_in_date;
    private int numberOfBedrooms;
    private String gender;
    private String description;
    private String posted_by;
}
