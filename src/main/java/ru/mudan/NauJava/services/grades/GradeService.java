package ru.mudan.NauJava.services.grades;

import java.time.LocalDate;
import ru.mudan.NauJava.entity.Grade;

public interface GradeService {
    Grade createGrade(Integer mark, LocalDate dateOfMark, String comment, Long studentId, Long subjectId);

    Grade findById(Long id);

    void deleteById(Long id);

    Grade updateGrade(Long id, Character letterForUpdate, Integer numberForUpdate, String descriptionForUpdate);
}
