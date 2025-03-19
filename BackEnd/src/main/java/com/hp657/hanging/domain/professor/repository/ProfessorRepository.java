package com.hp657.hanging.domain.professor.repository;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByNameAndDepartment(String name, Department department);

}
