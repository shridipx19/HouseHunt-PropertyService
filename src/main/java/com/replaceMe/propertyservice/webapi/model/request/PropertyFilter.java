package com.replaceMe.propertyservice.webapi.model.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class PropertyFilter {

    private Double latitude;
    private Double longitude;
    private Integer radius;
    private Integer minRent;
    private Integer maxRent;
    private Integer minDeposit;
    private Integer maxDeposit;
    private Integer minSetupCost;
    private Integer maxSetupCost;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate minMoveInDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate maxMoveInDate;

    private String gender;
}
