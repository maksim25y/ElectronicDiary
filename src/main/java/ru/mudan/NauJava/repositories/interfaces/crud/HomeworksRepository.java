package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Homework;

@Repository
public interface HomeworksRepository extends CrudRepository<Homework, Long> {
}
