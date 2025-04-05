package com.fema.tcc.gateways.http.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiException> handleNotFoundException(NotFoundException e) {
    ApiException error =
        ApiException.of(HttpStatus.NOT_FOUND.value(), e.getMessage(), HttpStatus.NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(SecurityException.class)
  public ResponseEntity<ApiException> handleSecurity(SecurityException ex) {
    ApiException error =
        ApiException.of(HttpStatus.FORBIDDEN.value(), ex.getMessage(), HttpStatus.FORBIDDEN);
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiException> handleIllegalArgument(IllegalArgumentException ex) {
    ApiException error =
        ApiException.of(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), HttpStatus.BAD_REQUEST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiException> handleGeneric(Exception ex) {
    ApiException error =
        ApiException.of(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
