package ru.mudan.NauJava.entity;

import jakarta.persistence.*;
import java.util.List;

@SuppressWarnings("AvoidStarImport")
@Entity
@Table(name = "classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "letter")
    private Character letter;
    @Column(name = "number")
    private Integer number;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "id")
    private List<Student> studentsList;
    @OneToMany(mappedBy = "id")
    private List<Homework> homeworkList;
    @OneToMany(mappedBy = "id")
    private List<Schedule> scheduleList;

    public ClassEntity(Character letter, Integer number, String description) {
        this.letter = letter;
        this.number = number;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public ClassEntity() {
    }

    @Override
    public String toString() {
        return "ClassEntity{"
                + "id="
                + id
                + ", letter="
                + letter
                + ", number="
                + number
                + ", description='"
                + description
                + '\''
                + '}';
    }
}
