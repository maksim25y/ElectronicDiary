package ru.mudan.NauJava.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.ClassEntity;
import ru.mudan.NauJava.repositories.interfaces.customs.ClassRepositoryCustom;

@Repository
public class ClassRepositoryImpl implements ClassRepositoryCustom {
    private final EntityManager entityManager;

    @Autowired
    public ClassRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ClassEntity> findByNumber(Integer number) {
        TypedQuery<ClassEntity> query = entityManager
                .createQuery("SELECT c FROM ClassEntity c "
                        + "WHERE c.number = :number", ClassEntity.class);
        query.setParameter("number", number);
        return query.getResultList();
    }
}
