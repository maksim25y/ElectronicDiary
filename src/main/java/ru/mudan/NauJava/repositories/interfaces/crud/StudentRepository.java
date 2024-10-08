package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
