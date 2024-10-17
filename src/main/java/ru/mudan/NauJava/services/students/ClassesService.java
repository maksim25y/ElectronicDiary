package ru.mudan.NauJava.services.students;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.mudan.NauJava.repositories.interfaces.crud.ClassRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.StudentRepository;

@Transactional
@Service
public class ClassesService {
    private final ClassRepository classRepositoryCustom;
    private final StudentRepository studentRepositoryCustom;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public ClassesService(ClassRepository classRepositoryCustom,
                          StudentRepository studentRepositoryCustom,
                          PlatformTransactionManager transactionManager) {
        this.classRepositoryCustom = classRepositoryCustom;
        this.studentRepositoryCustom = studentRepositoryCustom;
        this.transactionManager = transactionManager;
    }

    public void deleteClass(Long classId) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            var classForDeleting = classRepositoryCustom.findById(classId)
                    .orElseThrow(() -> new NoSuchElementException("Class not found"));

            var studentsOfClass = classForDeleting.getStudentsList();

            studentRepositoryCustom.deleteAll(studentsOfClass);

            classRepositoryCustom.delete(classForDeleting);

            transactionManager.commit(status);
        } catch (DataAccessException ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}
