package me.hyeonic.defaultconstructor.repository;

import me.hyeonic.defaultconstructor.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}