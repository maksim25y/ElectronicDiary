package ru.mudan.NauJava.controller.classes;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mudan.NauJava.services.classes.ClassesService;

@RestController
@RequestMapping("/api/v1/classes")
@Tag(name = "Классы", description = "API для взаимодействия с классами")
public class ClassController {
    private final ClassesService classesService;

    @Autowired
    public ClassController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable("id") Long id) {
        classesService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}
