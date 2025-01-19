package com.replaceMe.propertyservice.webapi.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Getter
@Setter
public class PropertyRequest {

    @NotNull(message = "Location cannot be null")
    private String maps_url;

    @NotNull(message = "Rent cannot be null")
    @Min(value = 1000, message = "Rent must be at least 1000")
    @Max(value = 100000, message = "Rent cannot exceed 100000")
    private int rent;

    @NotNull(message = "Deposit cannot be null")
    @Min(value = 1000, message = "Deposit must be at least 1000")
    @Max(value = 100000, message = "Deposit cannot exceed 100000")
    private int deposit;

    @NotNull(message = "Setup cost cannot be null")
    @Min(value = 1000, message = "Setup cost must be at least 1000")
    @Max(value = 100000, message = "Setup cost cannot exceed 100000")
    private int setUp_cost;
// future validation
    @NotNull(message = "Move-in date cannot be null")
    @JsonFormat(pattern = "dd/MM/yyyy")  // Use Jackson's @JsonFormat for custom date format
    @Future(message = "Check-in date must be a future date")
    private LocalDate move_in_date;

    @NotNull(message = "Number of bedrooms cannot be null")
    @Min(value = 1, message = "Number of bedrooms must be at least 1")
    @Max(value = 10, message = "Number of bedrooms cannot exceed 10")
    private int numberOfBedrooms;

    @Pattern(regexp = "M|F", message = "Gender must be 'M' or 'F' if provided")
    private String gender; // Optional field, no validation needed if not provided

    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    private String description; // Optional, so we use @Size instead of @NotNull
}
