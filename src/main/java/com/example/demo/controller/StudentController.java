package com.example.demo.controller;

import com.example.demo.dto.AddStudentRequestDTO;
import com.example.demo.dto.GetStudentRequestDTO;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping(path = "/{id}")
    public List<GetStudentRequestDTO> getStudents(@PathVariable Integer id) {
        return service.getAllStudentsDTOFromGroupID(id);
    }

    @PostMapping(path = "/{id}")
    public void addStudent(@RequestBody AddStudentRequestDTO student, @PathVariable Integer id) {
        service.addStudent(student, id);
    }

    @DeleteMapping("/{studentID}")
    public boolean removeStudent(@PathVariable String studentID) {
        try {
            service.remove(Integer.valueOf(studentID));
            return true;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
