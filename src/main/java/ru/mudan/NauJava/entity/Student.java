package ru.mudan.NauJava.entity;

public class Student {
    private Long id;
    private String firstname;
    private String lastname;
    private Integer numberOfClass;

    public Student(String firstname, String lastname, Integer numberOfClass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberOfClass = numberOfClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getNumberOfClass() {
        return numberOfClass;
    }

    public void setNumberOfClass(Integer numberOfClass) {
        this.numberOfClass = numberOfClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", numberOfClass=" + numberOfClass +
                '}';
    }
}
