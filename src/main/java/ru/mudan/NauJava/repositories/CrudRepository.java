package ru.mudan.NauJava.repositories;

public interface CrudRepository<T,ID> {
    T create(T entity);

    T read(ID id);

    T update(ID id,T entity);

    void delete(ID id);
}
