package com.replaceMe.propertyservice.webapi.exception;

import com.replaceMe.propertyservice.webapi.model.Details;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationException extends RuntimeException {
    private final String errorCode;
    private final String message;

    public ValidationException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
