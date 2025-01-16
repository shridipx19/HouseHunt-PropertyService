package com.replaceMe.propertyservice.webapi.util;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class CoordinatesFetcher {

    public String expandShortenedUrl(String shortenedUrl) throws IOException {
        URL url = new URL(shortenedUrl);

        // Open the connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(false); // Don't follow redirects automatically

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Check if it's a redirect (status code 3xx)
        if (responseCode == HttpURLConnection.HTTP_MOVED_PERM ||
                responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
            // Get the "Location" header to find the redirected URL
            return connection.getHeaderField("Location");
        } else
            throw new RuntimeException("Exception while expanding shortened URL");
    }
    public GeoJsonPoint extractLocationCoordinates(String expandedUrl) {
        Pattern pattern = Pattern.compile(Constants.COORDINATES_FROM_URL_REGEX);
        Matcher matcher = pattern.matcher(expandedUrl);

        if (matcher.find()) {
            double latitude = Double.parseDouble(matcher.group(1));
            double longitude = Double.parseDouble(matcher.group(2));
            System.out.println("latitude:" + latitude);
            System.out.println("longitude: " + longitude);
            return new GeoJsonPoint(latitude, longitude);

        } else {
            throw new RuntimeException("Missing Coordinates in the expanded URL");
        }
    }
}
