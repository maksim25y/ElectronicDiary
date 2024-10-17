package ru.mudan.NauJava.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "date_of_mark", columnDefinition = "DATE")
    private LocalDate dateOfMark;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Grade(Integer mark, LocalDate dateOfMark, String comment, Student student, Subject subject) {
        this.mark = mark;
        this.dateOfMark = dateOfMark;
        this.comment = comment;
        this.student = student;
        this.subject = subject;
    }

    public Grade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public LocalDate getDateOfMark() {
        return dateOfMark;
    }

    public void setDateOfMark(LocalDate dateOfMark) {
        this.dateOfMark = dateOfMark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Grade{"
                + "id="
                + id
                + ", mark="
                + mark
                + ", dateOfMark="
                + dateOfMark
                + ", comment='"
                + comment + '\''
                + '}';
    }
}
