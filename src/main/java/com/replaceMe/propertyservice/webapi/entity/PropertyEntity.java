package com.replaceMe.propertyservice.webapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "property_details") // This maps to the "property_details" collection in MongoDB
public class PropertyEntity {

    @Id
    private String id;

    @Field("location")
    private String location;

    @Field("rent")
    private double rent;

    @Field("deposit")
    private double deposit;

    @Field("setUp_cost")
    private double setUpCost;

    @Field("move_in_date")
    private LocalDate moveInDate; // Using LocalDate for dates

    @Field("numberOfBedrooms")
    private int numberOfBedrooms;

    @Field("gender")
    private String gender;

    @Field("description")
    private String description;
}
