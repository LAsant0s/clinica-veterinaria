package com.assis.controller.controllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assis.exceptions.EntityNotFoundException;
import com.assis.exceptions.InvalidOperationException;

@ControllerAdvice
public class Advice {
	
	 @ResponseBody
     @ExceptionHandler(InvalidOperationException.class)
     @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
     String InvalidOperationHandler(InvalidOperationException ex) {
             return ex.getMessage();
     }
	 
	 @ResponseBody
     @ExceptionHandler(EntityNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     String EntityNotFoundHandler(EntityNotFoundException ex) {
             return ex.getMessage();
     }
	 
	 @ResponseBody
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		 Map<String, String> errors = new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error) -> {
			 String fieldName = ((FieldError) error).getField();
			 String errorMessage = error.getDefaultMessage();
			 errors.put(fieldName, errorMessage);
		 });
        return errors;
    }
	 
}
