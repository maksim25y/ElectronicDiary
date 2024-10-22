package ru.mudan.NauJava.controller.subjects.payload;

import lombok.*;
import ru.mudan.NauJava.entity.Subject;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubjectResponse {
    private Long id;
    private String name;
    private String type;
    private String code;
    private String description;

    public SubjectResponse(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.type = subject.getType();
        this.code = subject.getCode();
        this.description = subject.getDescription();
    }
}
