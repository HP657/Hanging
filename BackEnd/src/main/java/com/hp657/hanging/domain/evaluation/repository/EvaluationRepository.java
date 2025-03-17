package com.hp657.hanging.domain.evaluation.repository;

import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
