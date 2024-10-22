package ru.mudan.NauJava.services.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mudan.NauJava.controller.subjects.payload.SubjectResponse;
import ru.mudan.NauJava.entity.Subject;
import ru.mudan.NauJava.repositories.interfaces.crud.SubjectRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectsService {
    private final SubjectRepository subjectRepository;

    public List<SubjectResponse> findAll() {
        return ((ArrayList<Subject>) subjectRepository
                .findAll()).stream()
                .map(SubjectResponse::new).collect(Collectors.toList());
    }
}
