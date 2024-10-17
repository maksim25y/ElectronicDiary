package ru.mudan.NauJava.repositories.interfaces.customs;

import java.util.List;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Subject;

@Repository
public interface SubjectsRepositoryCustom {
    List<Subject> findByCode(String code);

    List<Subject> findByType(String type);
}
