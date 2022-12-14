package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.dto.AddStudentRequestBody;
import com.example.demo.dto.GetStudentResponseBody;
import com.example.demo.entity.Student;
import com.example.demo.exception_handling.NoSuchEntityException;
import com.google.common.base.Preconditions;
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

    public List<GetStudentResponseBody> getAllStudentsResponseBodyByGroupID(Integer groupID) {
        return studentMapper.getListStudentResponseBody(repository.findAllByGroup_Id(groupID));
    }

    @Override
    public void addStudent(AddStudentRequestBody student) {
        Preconditions.checkArgument(!student.getName().isEmpty(), new IllegalArgumentException("Student name is empty"));
        repository.save(studentMapper.getStudent(student, groupService.getGroup(student.getGroupID())));
    }

    /*
    Вот здесь я пока не нашёл решение как корректно обработать удаление
    Потому пока если всё окей, я выбрасываю, что всё окей
     */
    @Override
    public StatusOperation remove(Integer studentID) {
        Optional<Student> student = repository.findById(studentID);
        Preconditions.checkArgument(student.isPresent(),
                new NoSuchEntityException("Student by id = " + studentID + " not found"));
        repository.delete(student.get());
        return new StatusOperation(StatusOperation.Status.SUCCESSFULLY, "OK");
    }

}
