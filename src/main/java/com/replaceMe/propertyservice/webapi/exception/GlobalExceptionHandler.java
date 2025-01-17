package com.replaceMe.propertyservice.webapi.exception;

import com.replaceMe.propertyservice.webapi.model.ErrorCode;
import com.replaceMe.propertyservice.webapi.model.ExceptionResponse;
import com.replaceMe.propertyservice.webapi.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // You can loop through the errors to build a more detailed message
        String errorMessage = "Validation failed: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(AuthenticationServiceException.class)
//    public ResponseEntity<ExceptionResponse> handleAuthenticationException() {
//    ExceptionResponse exceptionResponse = ExceptionResponse.builder()
//            .error_code(ErrorCode.TOKEN_EXPIRED)
//            .message(Constants.EXPIRED_TOKEN)
//            .build();
//        return new ResponseEntity<>(exceptionResponse, (HttpStatus.UNAUTHORIZED));
//    }

//    @ExceptionHandler(AuthorizationDeniedException.class)
//    public ResponseEntity<ExceptionResponse> handleAuthorizationException() {
//        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
//                .error_code(ErrorCode.TOKEN_EXPIRED)
//                .message(Constants.EXPIRED_TOKEN)
//                .build();
//        return new ResponseEntity<>(exceptionResponse, (HttpStatus.UNAUTHORIZED));
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException() {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .error_code(ErrorCode.RESOURCE_NOT_FOUND)
                .message(Constants.RESOURCE_NOT_FOUND)
                .build();
        return new ResponseEntity<>(exceptionResponse, (HttpStatus.NOT_FOUND));
    }

//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<Object> handleValidationException(ValidationException ex) {
//        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
//                .error_code(ErrorCode.INVALID_REQUEST_BODY)
//                .message(Constants.RESOURCE_NOT_FOUND)
//                .build();
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}
