package com.example.moodle.service;

import com.example.moodle.dto.AddStudentRequestBody;
import com.example.moodle.dto.GetStudentResponseBody;

import java.util.List;

public interface StudentService {
    List<GetStudentResponseBody> getAllStudentsResponseBodyByGroupID(Integer id);

    void addStudent(AddStudentRequestBody student);

    StatusOperation remove(Integer id);


}
