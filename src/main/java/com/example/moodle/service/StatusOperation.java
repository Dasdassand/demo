package com.example.moodle.service;


public record StatusOperation(com.example.moodle.service.StatusOperation.Status status, String description) {
    public enum Status {
        SUCCESSFULLY, ERROR
    }

}
