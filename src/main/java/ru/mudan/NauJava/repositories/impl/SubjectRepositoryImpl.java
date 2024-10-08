package ru.mudan.NauJava.repositories.impl;

import jakarta.persistence.EntityManager;
import java.util.List;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mudan.NauJava.entity.Subject;
import ru.mudan.NauJava.repositories.interfaces.customs.SubjectsRepositoryCustom;

@Repository
public class SubjectRepositoryImpl implements SubjectsRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public SubjectRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Subject> findByCode(String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);

        Root<Subject> subjectRoot = criteriaQuery.from(Subject.class);
        Predicate namePredicate = criteriaBuilder.equal(subjectRoot.get("code"), code);

        criteriaQuery.select(subjectRoot).where(namePredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Subject> findByType(String type) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);

        Root<Subject> subjectRoot = criteriaQuery.from(Subject.class);
        Predicate namePredicate = criteriaBuilder.equal(subjectRoot.get("type"), type);

        criteriaQuery.select(subjectRoot).where(namePredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
