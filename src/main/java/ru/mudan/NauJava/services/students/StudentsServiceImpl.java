package ru.mudan.NauJava.services.students;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.mudan.NauJava.controller.students.payload.StudentRequest;
import ru.mudan.NauJava.controller.students.payload.StudentResponse;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.repositories.interfaces.crud.ClassRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.StudentRepository;

@Component
@Transactional
public class StudentsServiceImpl implements StudentsService {
    private final ClassRepository classRepositoryCustom;
    private final StudentRepository studentRepositoryCustom;

    @Autowired
    public StudentsServiceImpl(ClassRepository classRepositoryCustom,
                               StudentRepository studentRepositoryCustom) {
        this.classRepositoryCustom = classRepositoryCustom;
        this.studentRepositoryCustom = studentRepositoryCustom;
    }


    @Override
    public StudentResponse findById(Long id) {
        var foundStudent = studentRepositoryCustom.findById(id)
                .orElseThrow(() -> new NoSuchElementException("entity.not.found"));
        return StudentResponse
                .builder()
                .id(foundStudent.getId())
                .firstname(foundStudent.getFirstname())
                .lastname(foundStudent.getLastname())
                .email(foundStudent.getEmail())
                .classId(foundStudent.getClassEntity().getId())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        studentRepositoryCustom.deleteById(id);
    }

    @Override
    public StudentResponse update(Long id,
                                  StudentRequest studentRequest) {
        var classForStudent = classRepositoryCustom.findById(studentRequest.classId())
                .orElseThrow(() -> new NoSuchElementException("entity.not.found"));

        Student studentForUpdate =
                new Student(studentRequest.firstname(),
                studentRequest.lastname(),
                studentRequest.email());
        studentForUpdate.setId(id);
        studentForUpdate.setClassEntity(classForStudent);

        var updatedStudent = studentRepositoryCustom.save(studentForUpdate);

        return StudentResponse
                .builder()
                .id(updatedStudent.getId())
                .firstname(updatedStudent.getFirstname())
                .lastname(updatedStudent.getLastname())
                .email(updatedStudent.getEmail())
                .classId(updatedStudent.getClassEntity().getId())
                .build();
    }
}
