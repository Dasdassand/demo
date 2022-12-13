package com.example.demo.mapper;

import com.example.demo.dto.AddStudentRequestDTO;
import com.example.demo.dto.GetStudentRequestDTO;
import com.example.demo.entity.Group;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    List<GetStudentRequestDTO> getAllDTO(List<Student> students);

    @Mapping(target = "entranceDate", expression = "java(new java.util.Date())")
    Student getStudent(AddStudentRequestDTO studentDTO, Group group);
}
