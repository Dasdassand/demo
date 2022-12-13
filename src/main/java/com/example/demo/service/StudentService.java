package com.example.demo.service;

import com.example.demo.dto.AddStudentRequestDTO;
import com.example.demo.dto.GetStudentRequestDTO;
import java.util.List;

public interface StudentService {
    List<GetStudentRequestDTO> getAllStudentsDTOFromGroupID(Integer id);
    void addStudent(AddStudentRequestDTO student,Integer id);

    void remove(Integer id);


}
