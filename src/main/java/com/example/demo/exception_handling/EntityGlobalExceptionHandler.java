package com.example.demo.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EntityGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EntityIncorrectData> handleException(NoSuchEntityException ex) {
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<EntityIncorrectData> handleException(NoCorrectDataDTO ex) {
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
