package ru.mudan.NauJava.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mudan.NauJava.entity.ClassEntity;
import ru.mudan.NauJava.entity.Grade;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.entity.Subject;
import ru.mudan.NauJava.repositories.impl.ClassRepositoryImpl;
import ru.mudan.NauJava.repositories.impl.SubjectRepositoryImpl;
import ru.mudan.NauJava.repositories.interfaces.crud.ClassRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.GradesRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.StudentRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.SubjectRepository;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
public class CustomRepositoriesTest {
    private final GradesRepository gradeRepository;
    private final ClassRepositoryImpl classRepository;
    private final SubjectRepositoryImpl subjectRepository;
    private final SubjectRepository subjectRepositoryCRUD;
    private final ClassRepository classRepositoryCRUD;
    private final StudentRepository studentRepositoryCRUD;

    @Autowired
    public CustomRepositoriesTest(GradesRepository gradeRepository,
                                  ClassRepositoryImpl classRepository,
                                  SubjectRepositoryImpl subjectRepository,
                                  SubjectRepository subjectRepositoryCRUD,
                                  ClassRepository classRepositoryCRUD,
                                  StudentRepository studentRepositoryCRUD) {
        this.gradeRepository = gradeRepository;
        this.classRepository = classRepository;
        this.subjectRepository = subjectRepository;
        this.subjectRepositoryCRUD = subjectRepositoryCRUD;
        this.classRepositoryCRUD = classRepositoryCRUD;
        this.studentRepositoryCRUD = studentRepositoryCRUD;
    }

    @BeforeEach
    void clearTables(){
        gradeRepository.deleteAll();
        subjectRepositoryCRUD.deleteAll();
        studentRepositoryCRUD.deleteAll();
        classRepositoryCRUD.deleteAll();
    }

    @Test
    void findSubjectByCodeThatPresent(){
        var subject = new Subject("Math","main","M81","test");
        var createdSubject = subjectRepositoryCRUD.save(subject);
        assertAll("Created subject",
                () -> assertNotNull(subject.getId()),
                () -> assertEquals(subject.getName(),createdSubject.getName()),
                () -> assertEquals(subject.getType(),createdSubject.getType()),
                () -> assertEquals(subject.getCode(),createdSubject.getCode()));

        var foundSubjects = subjectRepository.findByCode(subject.getCode());

        assertEquals(1,foundSubjects.size());
    }

    @Test
    void findSubjectByCodeThatDoesNotPresent(){
        var foundSubjects = subjectRepository.findByCode("Test code");

        assertEquals(0,foundSubjects.size());
    }

    @Test
    void findSubjectByTypeThatPresent(){
        var subject = new Subject("Math","main","M81","test");
        var createdSubject = subjectRepositoryCRUD.save(subject);
        assertAll("Created subject",
                () -> assertNotNull(subject.getId()),
                () -> assertEquals(subject.getName(),createdSubject.getName()),
                () -> assertEquals(subject.getType(),createdSubject.getType()),
                () -> assertEquals(subject.getCode(),createdSubject.getCode()));

        var foundSubjects = subjectRepository.findByType(subject.getType());

        assertEquals(1,foundSubjects.size());
    }

    @Test
    void findSubjectByTypeDoesNotPresent(){
        var foundSubjects = subjectRepository.findByType("Test type");

        assertEquals(0,foundSubjects.size());
    }

    @Test
    void findClassEntityByNumberThatPresent(){
        var classEntity = new ClassEntity('A',10,"Test description");
        var createdClassEntity = classRepositoryCRUD.save(classEntity);

        assertAll("Created class entity",
                () -> assertNotNull(createdClassEntity.getId()),
                () -> assertEquals(classEntity.getLetter(),createdClassEntity.getLetter()),
                () -> assertEquals(classEntity.getNumber(),createdClassEntity.getNumber()),
                () -> assertEquals(classEntity.getDescription(),createdClassEntity.getDescription()));

        var foundClassEntity = classRepository.findByNumber(classEntity.getNumber());

        assertEquals(1,foundClassEntity.size());
    }

    @Test
    void findClassEntityByNumberDoesNotPresent(){
        var foundClasses = classRepository.findByNumber(1);

        assertEquals(0,foundClasses.size());
    }

    @Test
    void findGradeByDateOfMarkThatPresent(){
        var classEntity = new ClassEntity('A',10,"Test description");
        var createdClassEntity = classRepositoryCRUD.save(classEntity);

        var student = new Student("Maks","Ivanov","test@mail.ru");
        student.setClassEntity(createdClassEntity);
        var createdStudent = studentRepositoryCRUD.save(student);

        var subject = new Subject("Math","main","M32","test");
        var createdSubject = subjectRepositoryCRUD.save(subject);

        var dateForFound = LocalDate.of(2024,10,12);
        var grade = new Grade(4,dateForFound,"Some errors",createdStudent,createdSubject);
        gradeRepository.save(grade);

        var foundGrade = gradeRepository.findByDateOfMark(dateForFound);

        assertEquals(1,foundGrade.size());
    }
}
