package com.hp657.hanging.domain.professor.repository;

import com.hp657.hanging.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
