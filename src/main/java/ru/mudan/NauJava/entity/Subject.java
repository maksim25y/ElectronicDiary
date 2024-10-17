package ru.mudan.NauJava.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "subject")
    private List<Grade> gradesList;

    public Subject(String name, String type, String code) {
        this.name = name;
        this.type = type;
        this.code = code;
    }

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Subject{"
                +
                "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", type='"
                + type
                + '\''
                + ", code='"
                + code
                + '\''
                + '}';
    }
}
