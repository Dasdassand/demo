package com.example.moodle.exception_handling;

import com.example.moodle.service.StatusOperation;
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
    public ResponseEntity<EntityIncorrectData> handleException(IllegalArgumentException ex) {
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public StatusOperation handleException(NoSuchStudentByIDDeleteException ex) {
        return new StatusOperation(StatusOperation.Status.ERROR, ex.getMessage());
    }

}
