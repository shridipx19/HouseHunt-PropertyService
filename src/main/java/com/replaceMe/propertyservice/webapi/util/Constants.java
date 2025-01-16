package com.replaceMe.propertyservice.webapi.util;

public class Constants {
    public static final String DATE_FORMAT_REGEX = "\"^(0[1-9]|[12]\\\\d|3[01])/(0[1-9]|1[0-2])/(\\\\d{4})$\\n\"";
    public static final String EXPIRED_TOKEN = "Authorization token has expired";
    public static final String INVALID_REQUEST = "The request body has invalid or missing fields";
    public static final String UNAUTHORIZED_ACTION = "User is not authorized to do the action";
    public static final String RESOURCE_NOT_FOUND = "The requested resource <resource_name> was not found";
    public static final String COORDINATES_FROM_URL_REGEX = "@([+-]?\\d+\\.\\d+),([+-]?\\d+\\.\\d+)";
}
