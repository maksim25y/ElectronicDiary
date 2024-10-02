package ru.mudan.NauJava.services;

import ru.mudan.NauJava.entity.Student;

import java.util.Optional;

public interface StudentService {
    void createStudent(String firstname, String lastname, Integer numberOfClass);
    Optional<Student> findById(Long id);
    void deleteById(Long id);

    void update(Long id, String nameForUpdate, String lastnameForUpdate, Integer numberOfClassForUpdate);
}
