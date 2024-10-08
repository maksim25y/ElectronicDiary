package ru.mudan.NauJava.readers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.services.StudentService;

import java.util.Optional;

@Component
public class CommandProcessor
{
    private final StudentService studentService;
    @Autowired
    public CommandProcessor(StudentService studentService) {
        this.studentService = studentService;
    }
    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch(cmd[0])
        {
            case "create" ->
            {
                var createdStudent = studentService.createStudent(cmd[1],cmd[2],Integer.parseInt(cmd[3]));
                System.out.println("Школьник успешно добавлен...");
                System.out.println(createdStudent);
            }
            case "read" ->
            {
                Optional<Student> optionalStudent = Optional.ofNullable(studentService.findById(Long.parseLong(cmd[1])));
                optionalStudent.ifPresentOrElse(System.out::println,
                        ()->System.out.println("Школьник с данным id отсутствует"));
            }
            case "update" ->
            {
                var updatedStudent = studentService.update(Long.valueOf(cmd[1]),cmd[2],cmd[3], Integer.valueOf(cmd[4]));
                System.out.println("Информация о школьнике обновлена");
                System.out.println(updatedStudent);
            }
            case "delete" ->
            {
                studentService.deleteById(Long.valueOf(cmd[1]));
                System.out.println("Школьник с данным id удалён");
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
