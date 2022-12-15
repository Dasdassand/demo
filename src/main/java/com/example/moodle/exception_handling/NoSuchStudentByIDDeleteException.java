package com.example.moodle.exception_handling;

public class NoSuchStudentByIDDeleteException extends NullPointerException {
    public NoSuchStudentByIDDeleteException(String s) {
        super(s);
    }
}
