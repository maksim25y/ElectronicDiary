package ru.mudan.NauJava.controller.students.payload;

import lombok.Builder;

@Builder
public record StudentResponse(
        Long id,
        String firstname,
        String lastname,
        String email,
        Long classId
) {
}
