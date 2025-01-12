package com.replaceMe.propertyservice.webapi.model;

import lombok.Builder;

import java.util.List;

@Builder
public class ExceptionResponse {
    private ErrorCode error_code;
    private String message;
    private List<Details> details;
}
