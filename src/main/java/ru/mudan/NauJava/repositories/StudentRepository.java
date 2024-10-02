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
    public void create(Student student) {
        student.setId((long) studentContainer.size());
        studentContainer.add(student);
    }

    @Override
    public Student read(Long id) {
        if(idIsValid(id)){
            return studentContainer.get(Math.toIntExact(id));
        }
        return null;
    }

    @Override
    public void update(Long id,Student student) {
        if(id!=null){
            if(idIsValid(id)){
                student.setId(id);
                studentContainer.set(Math.toIntExact(id),student);
            }
        }
    }

    @Override
    public void delete(Long id) {
        if(idIsValid(id)){
            studentContainer.remove(Math.toIntExact(id));
        }
    }
    private boolean idIsValid(Long id){
        int studentContainerSize = studentContainer.size();
        return id>=0&&id<studentContainerSize;
    }
}
