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

import com.assis.exceptions.AnamneseNotFoundException;
import com.assis.exceptions.AnimalNotFoundException;
import com.assis.exceptions.ConsultaNotFoundException;
import com.assis.exceptions.DoencaNotFoundException;
import com.assis.exceptions.ExameNotFoundException;

@ControllerAdvice
public class Advice {
	
	 @ResponseBody
     @ExceptionHandler(ExameNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     String ExameNotFoundHandler(ExameNotFoundException ex) {
             return ex.getMessage();
     }
	 
	 @ResponseBody
     @ExceptionHandler(AnimalNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     String AnimalNotFoundHandler(AnimalNotFoundException ex) {
             return ex.getMessage();
     }
	 
	 @ResponseBody
     @ExceptionHandler(ConsultaNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     String ConsultaNotFoundHandler(ConsultaNotFoundException ex) {
             return ex.getMessage();
     }
	 
	 @ResponseBody
     @ExceptionHandler(AnamneseNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     String AnamneseNotFoundHandler(AnamneseNotFoundException ex) {
             return ex.getMessage();
     }
	 
	 @ResponseBody
     @ExceptionHandler(DoencaNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     String DoencaNotFoundHandler(DoencaNotFoundException ex) {
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
