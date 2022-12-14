package com.example.demo.service;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public record StatusOperation(com.example.demo.service.StatusOperation.Status status, String description) {
    enum Status {
        SUCCESSFULLY, ERROR
    }

}
