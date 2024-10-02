package ru.mudan.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.repositories.StudentRepository;

import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(String firstname, String lastname, Integer numberOfClass) {
        Student newStudent = new Student(firstname,lastname,numberOfClass);
        studentRepository.create(newStudent);
    }
    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(studentRepository.read(id));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void update(Long id, String nameForUpdate, String lastnameForUpdate, Integer numberOfClassForUpdate) {
        Student studentForUpdate = new Student(nameForUpdate,lastnameForUpdate,numberOfClassForUpdate);
        studentRepository.update(id,studentForUpdate);
    }
}
