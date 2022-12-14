package com.example.demo.controller;

import com.example.demo.dto.AddStudentRequestBody;
import com.example.demo.dto.GetStudentResponseBody;
import com.example.demo.service.StatusOperation;
import com.example.demo.service.StudentService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping(path = "/{groupID}")
    public List<GetStudentResponseBody> getStudents(@PathVariable Integer groupID) {
        return service.getAllStudentsResponseBodyByGroupID(groupID);
    }

    @PostMapping(path = "/{groupID}")
    public void addStudent(@RequestBody AddStudentRequestBody student, @PathVariable Integer groupID) {
        Preconditions.checkArgument(student != null, new IllegalArgumentException("Student is empty"));
        Preconditions.checkArgument(groupID.describeConstable().isPresent(), new IllegalArgumentException("Group id is empty"));
        student.setGroupID(groupID);
        service.addStudent(student);
    }

    @DeleteMapping("/{studentID}")
    public StatusOperation removeStudent(@PathVariable Integer studentID) {
        Preconditions.checkArgument(studentID.describeConstable().isPresent(), new IllegalArgumentException("Student id is empty"));
        return service.remove(studentID);
    }
}
