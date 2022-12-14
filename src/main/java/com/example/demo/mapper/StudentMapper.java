package com.example.demo.mapper;

import com.example.demo.dto.AddStudentRequestBody;
import com.example.demo.dto.GetStudentResponseBody;
import com.example.demo.dto.StudentDomain;
import com.example.demo.entity.Group;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    List<GetStudentResponseBody> getListStudentResponseBody(List<Student> students);

    @Mapping(target = "entranceDate", expression = "java(new java.util.Date())")
    Student getStudent(AddStudentRequestBody student, Group group);

    StudentDomain getStudentDomain(Student student);

    List<StudentDomain> getStudentsDomain(List<Student> student);

}
