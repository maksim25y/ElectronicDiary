package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
