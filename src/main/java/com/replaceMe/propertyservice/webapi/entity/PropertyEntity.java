package com.replaceMe.propertyservice.webapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "properties")
public class PropertyEntity {

    @Id
    private String _id;

    @Field("maps_url")
    private String mapsUrl;

    private GeoJsonPoint location;

    private int rent;
    private int deposit;

    @Field("setUp_cost")
    private int set_up_cost;

    @Field("move_in_date")
    @JsonFormat(pattern = "dd/MM/yyyy")  // Use Jackson's @JsonFormat for custom date format
    private LocalDate move_in_date;

    @Field("numberOfBedrooms")
    private int numberOfBedrooms;

    private String gender;
    private String description;

    @Field("posted_by")
    private String posted_by;
}
