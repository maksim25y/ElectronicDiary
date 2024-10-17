package ru.mudan.NauJava.services.students;

import ru.mudan.NauJava.controller.students.payload.StudentRequest;
import ru.mudan.NauJava.controller.students.payload.StudentResponse;

public interface StudentsService {
    StudentResponse findById(Long id);

    void deleteById(Long id);

    StudentResponse update(Long id, StudentRequest studentRequest);
}
