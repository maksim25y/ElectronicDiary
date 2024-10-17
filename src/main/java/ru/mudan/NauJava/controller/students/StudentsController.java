package ru.mudan.NauJava.controller.students;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mudan.NauJava.controller.students.payload.StudentRequest;
import ru.mudan.NauJava.controller.students.payload.StudentResponse;
import ru.mudan.NauJava.services.students.StudentsServiceImpl;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "Школьники", description = "API для взаимодействия со школьниками")
public class StudentsController {
    private final StudentsServiceImpl studentsService;

    @Autowired
    public StudentsController(StudentsServiceImpl studentsService) {
        this.studentsService = studentsService;
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable("id") Long id,
                                         @RequestBody StudentRequest studentRequest) {
        return studentsService.update(id, studentRequest);
    }
}
