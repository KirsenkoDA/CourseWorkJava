package ru.vlsu.ispi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.ispi.model.Student;
import ru.vlsu.ispi.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> index() {
        return studentRepository.findAll();
    }
}
