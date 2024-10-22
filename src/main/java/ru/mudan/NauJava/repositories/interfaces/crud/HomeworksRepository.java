package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Homework;

@Repository
@RepositoryRestResource
public interface HomeworksRepository extends CrudRepository<Homework, Long> {
}
