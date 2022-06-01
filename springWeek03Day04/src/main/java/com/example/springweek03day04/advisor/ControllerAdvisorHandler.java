package com.example.springweek03day04.advisor;

import com.example.springweek03day04.DTO.API;
import com.example.springweek03day04.exception.InvalidException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisorHandler{

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<API> handlerMethodArgument(MethodArgumentNotValidException methodArgument){
        String message = methodArgument.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handlerDataIntegrity(DataIntegrityViolationException dataIntegrity){
        String message = dataIntegrity.getCause().getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity<API> handlerInvalidException(InvalidException invalidException){
        String message = invalidException.getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }


}
