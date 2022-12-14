package com.example.demo.service;

import com.example.demo.dto.AddStudentRequestBody;
import com.example.demo.dto.GetStudentResponseBody;

import java.util.List;

public interface StudentService {
    List<GetStudentResponseBody> getAllStudentsResponseBodyByGroupID(Integer id);

    void addStudent(AddStudentRequestBody student);

    StatusOperation remove(Integer id);


}
