package com.hp657.hanging.domain.professor.repository;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.professor.dto.ProfessorResponseDto;
import com.hp657.hanging.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByNameAndDepartment(String name, Department department);

    @Query(value = """
            SELECT
                d.id AS department_id,
                d.name AS department_name,
                p.id AS professor_id,
                p.name AS professor_name
            FROM departments d
            LEFT JOIN professors p ON d.id = p.department_id
            WHERE d.name = :departmentName
            """, nativeQuery = true)
    List<ProfessorResponseDto> findProfessorsByDepartmentName(String departmentName);


}
