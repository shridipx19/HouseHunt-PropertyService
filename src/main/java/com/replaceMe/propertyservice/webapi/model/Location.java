package com.replaceMe.propertyservice.webapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Getter
@Setter
public class Location {
    private static final String type = "Point";
    private GeoJsonPoint coordinates;

    // Constructor
    public Location(GeoJsonPoint coordinates) {
        this.coordinates = coordinates;
    }
}
