package com.grupo29.techchallengeriwatts.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
    FieldError fieldError = ex.getBindingResult().getFieldError();
    String errorMessage = fieldError.getDefaultMessage();
    HandlerException handlerException = new HandlerException(errorMessage);
    return new ResponseEntity<>(handlerException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
    String errorMessage = ex.getMessage();
    HandlerException handlerException = new HandlerException(errorMessage);
    return new ResponseEntity<>(handlerException, HttpStatus.BAD_REQUEST);
  }
}
