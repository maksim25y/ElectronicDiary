package ru.mudan.NauJava.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "deadline", columnDefinition = "DATE")
    private LocalDate deadline;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Homework(String title, String description, LocalDate deadline, ClassEntity classEntity, Subject subject) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.classEntity = classEntity;
        this.subject = subject;
    }

    public Homework() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
