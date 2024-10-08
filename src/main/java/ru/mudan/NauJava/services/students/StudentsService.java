package ru.mudan.NauJava.services.students;

import ru.mudan.NauJava.entity.Student;

public interface StudentsService {
    Student createStudent(String firstname, String lastname, String email, Long classId);

    Student findById(Long id);

    void deleteById(Long id);

    Student update(Long id, String nameForUpdate, String lastnameForUpdate, String emailForUpdate, Long classId);
}
