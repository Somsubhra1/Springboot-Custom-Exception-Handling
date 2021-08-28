package com.somsubhra.springbootexceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    //    Exception handler function to handle the incoming exception
    @ExceptionHandler(value = {ApiRequestException.class}) // pass the class from which we want to accept exceptions
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        //      1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //        2. Return response entity
        return new ResponseEntity<>(apiException, badRequest);

    }
}
