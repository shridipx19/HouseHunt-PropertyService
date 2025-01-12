package com.replaceMe.propertyservice.webapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "properties")
public class PropertyEntity {

    @Id
    private String id;

    @Field("maps_url")
    private String mapsUrl;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    private int rent;
    private int deposit;

    @Field("setUp_cost")
    private int setupCost;

    @Field("move_in_date")
    private String moveInDate;

    @Field("numberOfBedrooms")
    private int numberOfBedrooms;

    private String gender;
    private String description;

    @Field("posted_by")
    private String postedBy;
}
