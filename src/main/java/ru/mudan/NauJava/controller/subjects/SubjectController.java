package ru.mudan.NauJava.controller.subjects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mudan.NauJava.services.subjects.SubjectsService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectsService subjectService;

    @GetMapping
    public String showSubjects(Model model) {
        var subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "index";
    }
}
