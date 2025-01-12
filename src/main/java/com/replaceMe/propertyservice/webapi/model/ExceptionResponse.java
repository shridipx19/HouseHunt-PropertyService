package com.replaceMe.propertyservice.webapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ExceptionResponse {
    private ErrorCode error_code;
    private String message;
    private List<Details> details;
}
