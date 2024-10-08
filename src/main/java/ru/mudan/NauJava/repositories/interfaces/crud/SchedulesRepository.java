package ru.mudan.NauJava.repositories.interfaces.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Schedule;

@Repository
public interface SchedulesRepository extends CrudRepository<Schedule, Long> {
}
