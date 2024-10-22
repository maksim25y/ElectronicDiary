package ru.mudan.NauJava.repositories.interfaces.crud;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Grade;

@Repository
@RepositoryRestResource
public interface GradesRepository extends CrudRepository<Grade, Long> {
    /**
     * Находит все оценки за заданную дату
     *
     * @param dateOfMark дата оценки
     */
    @Query("SELECT g FROM Grade g WHERE g.dateOfMark = :dateOfMark")
    List<Grade> findByDateOfMark(LocalDate dateOfMark);
}
