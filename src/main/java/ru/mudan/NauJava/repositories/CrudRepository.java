package ru.mudan.NauJava.repositories;

import ru.mudan.NauJava.entity.Student;

public interface CrudRepository<T,ID> {
    void create(T entity);
    T read(ID id);
    void update(ID id,T entity);

    void update(Long id, Student student);

    void delete(ID id);
}
