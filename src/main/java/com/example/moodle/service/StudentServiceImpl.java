package com.example.moodle.service;

import com.example.moodle.exception_handling.NoSuchStudentByIDDeleteException;
import com.example.moodle.mapper.StudentMapper;
import com.example.moodle.repository.StudentRepository;
import com.example.moodle.dto.AddStudentRequestBody;
import com.example.moodle.dto.GetStudentResponseBody;
import com.example.moodle.entity.Student;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final GroupService groupService;
    private final StudentMapper studentMapper;

    public List<GetStudentResponseBody> getAllStudentsResponseBodyByGroupID(Integer groupID) {
        return studentMapper.getListStudentResponseBody(repository.findAllByGroup_Id(groupID));
    }

    @Override
    public void addStudent(AddStudentRequestBody student) {
        Preconditions.checkArgument(!student.getName().isEmpty(), new IllegalArgumentException("Student name is empty"));
        repository.save(studentMapper.getStudent(student, groupService.getGroup(student.getGroupID())));
    }

    @Override
    public StatusOperation remove(Integer studentID) {
        Optional<Student> student = repository.findById(studentID);
        student.orElseThrow(() -> new NoSuchStudentByIDDeleteException("no such student by id = " + studentID));
        repository.delete(student.get());
        return new StatusOperation(StatusOperation.Status.SUCCESSFULLY, "OK");
    }

}
