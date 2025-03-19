package com.hp657.hanging.domain.department.repository;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
    List<Department> findAllByOrderByIdAsc();
}
