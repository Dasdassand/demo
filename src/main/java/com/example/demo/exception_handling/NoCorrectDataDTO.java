package com.example.demo.exception_handling;

public class NoCorrectDataDTO extends RuntimeException{
    public NoCorrectDataDTO(String message) {
        super(message);
    }
}
