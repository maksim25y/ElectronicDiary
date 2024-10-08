package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.ClassEntity;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, Long> {
}
