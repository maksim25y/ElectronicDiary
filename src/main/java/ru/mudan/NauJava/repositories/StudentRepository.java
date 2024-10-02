package ru.mudan.NauJava.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mudan.NauJava.entity.Student;

import java.util.List;
@Component
public class StudentRepository implements CrudRepository<Student,Long>{
    private final List<Student>studentContainer;
    @Autowired
    public StudentRepository(List<Student> studentContainer) {
        this.studentContainer = studentContainer;
    }

    @Override
    public Student create(Student student) {
        int savedId = studentContainer.size();
        student.setId((long) savedId);
        studentContainer.add(student);
        return studentContainer.get(savedId);
    }

    @Override
    public Student read(Long id) {
        return studentContainer.get(Math.toIntExact(id));
    }

    @Override
    public Student update(Long id,Student student) {
            student.setId(id);
            studentContainer.set(Math.toIntExact(id),student);
            return studentContainer.get(Math.toIntExact(id));
        }

    @Override
    public void delete(Long id) {
        studentContainer.remove(Math.toIntExact(id));
    }
    public int sizeOfList(){
        return studentContainer.size();
    }
}
