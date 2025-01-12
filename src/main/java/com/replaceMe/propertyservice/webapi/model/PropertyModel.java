package com.replaceMe.propertyservice.webapi.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class PropertyModel {

    @Id
    private String id;
    private String location;
    private double rent;
    private double deposit;
    private double setUpCost;
    private Date moveInDate;
    private int numberOfBedrooms;
    private String gender;
    private String description;

    // Default constructor
    public PropertyModel() {}
}
