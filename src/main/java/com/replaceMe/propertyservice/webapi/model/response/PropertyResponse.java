package com.replaceMe.propertyservice.webapi.model.response;

import java.time.LocalDate;

public class PropertyResponse {
    private String mapsUrl;
    private double rent;
    private double deposit;
    private double setUpCost;
    private LocalDate moveInDate;
    private int numberOfBedrooms;
    private String gender;
    private String description;
    private String postedBy;  // This could be an ObjectId or a String representation, based on your use case

    private GeoLocation location; // GeoLocation to represent the Point with coordinates

    // GeoLocation class to handle "Point" type for MongoDB coordinates
    public static class GeoLocation {
        private String type;  // "Point"
        private double[] coordinates; // [longitude, latitude]

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(double[] coordinates) {
            this.coordinates = coordinates;
        }
    }
}
