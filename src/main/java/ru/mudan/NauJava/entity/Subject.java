package ru.mudan.NauJava.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
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
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "subject")
    private List<Grade> gradesList;

    public Subject(String name, String type, String code, String description) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
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
