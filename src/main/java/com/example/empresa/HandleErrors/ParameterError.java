package com.example.empresa.HandleErrors;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


@ControllerAdvice
public class ParameterError {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ResponseEntity<String> handleConflict(
        MethodArgumentNotValidException ex, WebRequest request) {
        

        List<Map<String, String>> errors= new ArrayList<Map<String,String>>();
        errors.add(Map.of("error code: ", "01"));
        ex.getBindingResult().getAllErrors().forEach(
            err -> {
                HashMap<String, String>error= new HashMap<>();
                error.put(((FieldError)err).getField(), err.getDefaultMessage());
                errors.add(error);
            }
        );

        return ResponseEntity.badRequest().body(errors.toString());

    }

    
    
}
