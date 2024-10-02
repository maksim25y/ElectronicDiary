package ru.mudan.NauJava.readers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mudan.NauJava.entity.Student;
import ru.mudan.NauJava.services.StudentService;
import ru.mudan.NauJava.services.StudentServiceImpl;

import java.util.Optional;

@Component
public class CommandProcessor
{
    private final StudentServiceImpl studentService;
    @Autowired
    public CommandProcessor(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch(cmd[0])
        {
            case "create" ->
            {
                studentService.createStudent(cmd[1],cmd[2],Integer.parseInt(cmd[3]));
                System.out.println("Школьник успешно добавлен...");
            }
            case "read" ->
            {
                Optional<Student> optionalStudent = studentService.findById(Long.parseLong(cmd[1]));
                optionalStudent.ifPresentOrElse(System.out::println,
                        ()->System.out.println("Школьник с данным id отсутствует"));
            }
            case "update" ->
            {
                studentService.update(Long.valueOf(cmd[1]),cmd[2],cmd[3], Integer.valueOf(cmd[4]));
                System.out.println("Информация о школьнике обновлена");
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
