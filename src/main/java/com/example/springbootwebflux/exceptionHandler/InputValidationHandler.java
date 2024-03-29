package com.example.springbootwebflux.exceptionHandler;

import com.example.springbootwebflux.exception.InputValidationException;
import com.example.springbootwebflux.model.InputFailedValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException exception){
        InputFailedValidationResponse response =new InputFailedValidationResponse();
        response.setErrorCode(exception.getErrorCode());
        response.setInput(exception.getInput());
        response.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
