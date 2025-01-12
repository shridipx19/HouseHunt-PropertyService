package com.replaceMe.propertyservice.webapi.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PropertyRequest {
    private String location;
    private double rent;
    private double deposit;
    private double setUpCost;
    private LocalDate moveInDate;
    private int numberOfBedrooms;
    private String gender;
    private String description;
}
