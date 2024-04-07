package com.example.productboot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.JsonMappingException;

@RestControllerAdvice
public class CustomExceptionController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<?> handleNumberFormatException(NumberFormatException ex) {
    return ResponseEntity.badRequest().build();
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<?> handleJsonParseException(HttpMessageNotReadableException ex) {

    Throwable rootCause = ex.getRootCause();

    if(rootCause instanceof JsonMappingException){
      JsonMappingException jsonMapException = (JsonMappingException) rootCause;
      String fieldName = jsonMapException.getPath().stream()
        .map(JsonMappingException.Reference::getFieldName)
        .findFirst()
        .orElse("unrecognized field");
        
      String errorMessage = "Error: '" + fieldName + "' must be an array";

      return ResponseEntity.badRequest().body(errorMessage);
    }
    
    return ResponseEntity.badRequest().body("Something bad happened with your request");
  }
}
