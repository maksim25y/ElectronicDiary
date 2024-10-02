package ru.mudan.NauJava.services;

import ru.mudan.NauJava.entity.Student;

public interface StudentService {
    Student createStudent(String firstname, String lastname, Integer numberOfClass);

    Student findById(Long id);

    void deleteById(Long id);

    Student update(Long id, String nameForUpdate, String lastnameForUpdate, Integer numberOfClassForUpdate);
}
