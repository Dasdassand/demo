package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.dto.AddStudentRequestDTO;
import com.example.demo.dto.GetStudentRequestDTO;
import com.example.demo.entity.Student;
import com.example.demo.exception_handling.NoCorrectDataDTO;
import com.example.demo.exception_handling.NoSuchEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final GroupService groupService;
    private final StudentMapper studentMapper;

    public List<GetStudentRequestDTO> getAllStudentsDTOFromGroupID(Integer id) {
        return studentMapper.getAllDTO(repository.findAllByGroup_Id(id));
    }

    @Override
    public void addStudent(AddStudentRequestDTO studentDTO, Integer groupId) {
        if (!studentDTO.getName().equals("")) {
            repository.save(studentMapper.getStudent(studentDTO, groupService.getGroup(groupId)));
        } else {
            throw new NoCorrectDataDTO("Student name not correct");

        }
    }

    @Override
    public void remove(Integer id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            repository.delete(student.get());
        } else {
            throw new NoSuchEntityException("No such student from id = " + id);
        }

    }

}
