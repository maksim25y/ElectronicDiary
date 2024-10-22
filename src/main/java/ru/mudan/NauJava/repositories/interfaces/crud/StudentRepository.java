package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Student;

@Repository
@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, Long> {
}
