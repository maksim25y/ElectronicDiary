package ru.mudan.NauJava.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mudan.NauJava.entity.ClassEntity;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.repositories.interfaces.crud.ClassRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.StudentRepository;
import ru.mudan.NauJava.services.classes.ClassesService;

import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClassesServiceTest {
    private final ClassesService classesService;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    @Autowired
    public ClassesServiceTest(ClassesService classesService, StudentRepository studentRepository, ClassRepository classRepository) {
        this.classesService = classesService;
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }

    @BeforeEach
    void clear(){
        studentRepository.deleteAll();
        classRepository.deleteAll();
    }
    @Test
    void deleteClassInTx() {
        ClassEntity classEntity = new ClassEntity('A',5,"test description");
        var createdClassEntity = classRepository.save(classEntity);

        assertNotNull(classRepository.findById(createdClassEntity.getId()));

        var student = new Student("Maks","Ivanov","test@mail.ru");

        student.setClassEntity(createdClassEntity);

        var createdStudent = studentRepository.save(student);

        assertNotNull(studentRepository.findById(createdStudent.getId()));

        var studentsOfClass = classRepository.findById(createdClassEntity.getId())
                .orElseThrow(() -> new NoSuchElementException("Class not found")).getStudentsList();

        assertEquals(1,studentsOfClass.size());

        classesService.deleteClass(createdClassEntity.getId());

        assertTrue(classRepository.findById(createdStudent.getId()).isEmpty());
        assertTrue(((List<Student>) studentRepository.findAll()).isEmpty());
    }
}
