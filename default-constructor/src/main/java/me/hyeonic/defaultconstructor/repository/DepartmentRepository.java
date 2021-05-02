package me.hyeonic.defaultconstructor.repository;

import me.hyeonic.defaultconstructor.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}