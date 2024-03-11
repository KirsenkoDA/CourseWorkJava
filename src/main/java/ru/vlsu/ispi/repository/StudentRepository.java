package ru.vlsu.ispi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.ispi.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
