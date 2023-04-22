package com.example.cafeteria.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandle {


    @ExceptionHandler(  value={ ExceptionCafeteria.class  })
    public ResponseEntity<Object> handleDataNotFoundException(Exception ex  ) {

        ApiException apiException = new ApiException(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }



}
