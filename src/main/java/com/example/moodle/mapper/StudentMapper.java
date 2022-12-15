package com.example.moodle.mapper;

import com.example.moodle.dto.AddStudentRequestBody;
import com.example.moodle.dto.GetStudentResponseBody;
import com.example.moodle.dto.StudentDomain;
import com.example.moodle.entity.Group;
import com.example.moodle.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    List<GetStudentResponseBody> getListStudentResponseBody(List<Student> students);

    @Mapping(target = "entranceDate", expression = "java(new java.util.Date())")
    Student getStudent(AddStudentRequestBody student, Group group);

    StudentDomain getStudentDomain(Student student);

    List<StudentDomain> getStudentsDomainList(List<Student> student);

}
