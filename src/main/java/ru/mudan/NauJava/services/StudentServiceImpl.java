package ru.mudan.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.repositories.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(String firstname, String lastname, Integer numberOfClass) {
        Student newStudent = new Student(firstname,lastname,numberOfClass);
        return studentRepository.create(newStudent);
    }
    @Override
    public Student findById(Long id) {
        if(idIsValid(id)){
            return studentRepository.read(id);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if(idIsValid(id)) {
            studentRepository.delete(id);
        }
    }

    @Override
    public Student update(Long id, String nameForUpdate, String lastnameForUpdate, Integer numberOfClassForUpdate) {
        if(idIsValid(id)){
            Student studentForUpdate = new Student(nameForUpdate,lastnameForUpdate,numberOfClassForUpdate);
            return studentRepository.update(id,studentForUpdate);
        }
        return null;
    }

    private boolean idIsValid(Long id) {
        int studentContainerSize = studentRepository.sizeOfList();
        return id>=0&&id<studentContainerSize;
    }
}
