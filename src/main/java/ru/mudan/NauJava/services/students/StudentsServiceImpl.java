package ru.mudan.NauJava.services.students;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.repositories.interfaces.crud.ClassRepository;
import ru.mudan.NauJava.repositories.interfaces.crud.StudentRepository;

@Component
@Transactional
public class StudentsServiceImpl implements StudentsService {
    private final ClassRepository classRepositoryCustom;
    private final StudentRepository studentRepositoryCustom;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public StudentsServiceImpl(ClassRepository classRepositoryCustom,
                               StudentRepository studentRepositoryCustom,
                               PlatformTransactionManager transactionManager) {
        this.classRepositoryCustom = classRepositoryCustom;
        this.studentRepositoryCustom = studentRepositoryCustom;
        this.transactionManager = transactionManager;
    }
    @Override
    public Student createStudent(String firstname, String lastname, String email, Long classId) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            var classForStudent = classRepositoryCustom.findById(classId);
            if (classForStudent.isPresent()) {
                var newStudent = new Student(firstname, lastname, email);
                newStudent.setClassEntity(classForStudent.get());
                return studentRepositoryCustom.save(newStudent);
            }
            transactionManager.commit(status);
        } catch (DataAccessException ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        throw new IllegalArgumentException("Не удалось сохранить школьника");
    }


    @Override
    public Student findById(Long id) {
        return studentRepositoryCustom.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Школьник с указанным id не найден"));
    }

    @Override
    public void deleteById(Long id) {
        studentRepositoryCustom.deleteById(id);
    }

    @Override
    public Student update(Long id,
                          String nameForUpdate,
                          String lastnameForUpdate,
                          String emailForUpdate, Long classId) {
        var classForStudent = classRepositoryCustom.findById(classId).orElseThrow(() -> new NoSuchElementException("Class not found"));

        Student studentForUpdate = new Student(nameForUpdate, lastnameForUpdate, emailForUpdate);
        studentForUpdate.setId(id);
        studentForUpdate.setClassEntity(classForStudent);

        return studentRepositoryCustom.save(studentForUpdate);
    }
}
