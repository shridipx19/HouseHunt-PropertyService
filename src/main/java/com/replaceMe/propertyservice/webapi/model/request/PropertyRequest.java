package com.replaceMe.propertyservice.webapi.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PropertyRequest {
    private String location;
    private int rent;
    private int deposit;
    private int setUpCost;
    private String moveInDate;
    private int numberOfBedrooms;
    private String gender;
    private String description;
}
