package ru.mudan.NauJava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mudan.NauJava.entity.ClassEntity;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.repositories.interfaces.crud.ClassRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.StudentRepository;
import ru.mudan.NauJava.services.students.StudentsServiceImpl;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {
    private final StudentsServiceImpl studentsService;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    @Autowired
    public StudentServiceTest(StudentsServiceImpl studentsService, StudentRepository studentRepository, ClassRepository classRepository) {
        this.studentsService = studentsService;
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }

    @BeforeEach
    void clear(){
        studentRepository.deleteAll();
        classRepository.deleteAll();
    }

    @Test
    void createStudentInTx() {
        ClassEntity classEntity = new ClassEntity('A',5,"test description");
        var createdClassEntity = classRepository.save(classEntity);

        var createdStudent = studentsService.createStudent("Maks","Ivanov","test@mail.ru",createdClassEntity.getId());

        Optional<Student> foundStudent = studentRepository.findById(createdStudent.getId());
        Assertions.assertTrue(foundStudent.isPresent());
    }
}
