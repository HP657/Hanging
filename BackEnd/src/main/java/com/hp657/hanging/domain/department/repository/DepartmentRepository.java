package com.hp657.hanging.domain.department.repository;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
