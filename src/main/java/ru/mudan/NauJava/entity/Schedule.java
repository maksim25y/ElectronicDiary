package ru.mudan.NauJava.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "day_of_week")
    private Integer dayOfWeek;
    @Column(name = "start_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @Column(name = "number_of_classroom")
    private Integer numberOfClassroom;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Schedule() {
    }

    public Schedule(Integer dayOfWeek,
                    LocalDateTime startTime,
                    Integer numberOfClassroom,
                    ClassEntity classEntity,
                    Subject subject) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.numberOfClassroom = numberOfClassroom;
        this.classEntity = classEntity;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getNumberOfClassroom() {
        return numberOfClassroom;
    }

    public void setNumberOfClassroom(Integer numberOfClassroom) {
        this.numberOfClassroom = numberOfClassroom;
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

    @Override
    public String toString() {
        return "Schedule{"
                + "id="
                + id + ", dayOfWeek='"
                + dayOfWeek
                + '\''
                + ", startTime="
                + startTime
                + ", numberOfClassroom="
                + numberOfClassroom
                + '}';
    }
}
