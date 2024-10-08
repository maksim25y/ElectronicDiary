package ru.mudan.NauJava.repositories.interfaces.customs;

import java.util.List;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.ClassEntity;

@Repository
public interface ClassRepositoryCustom {
    /**
     * Находит все классы с заданным номером класса
     *
     * @param number наименование номера класса
     */
    List<ClassEntity> findByNumber(Integer number);
}
