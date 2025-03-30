package com.hp657.hanging.domain.evaluation.repository;

import com.hp657.hanging.domain.evaluation.dto.CourseEvaluationDTO;
import com.hp657.hanging.domain.evaluation.dto.LectureEvaluationDTO;
import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query(value = """
            SELECT
                    d.name AS department,
                    p.name AS professor_name,
                    CAST(AVG(s.score) AS DOUBLE) AS average_score
                FROM departments d
                JOIN professors p ON d.id = p.department_id
                JOIN lectures l ON p.id = l.professor_id
                JOIN evaluations e ON l.id = e.lecture_id
                JOIN scopes s ON e.id = s.evaluation_id
                GROUP BY d.name, p.name
                ORDER BY d.name, p.name, average_score DESC
    """, nativeQuery = true)
    List<LectureEvaluationDTO> findLectureEvaluationsNative();

    @Query(value = """
            SELECT
                d.name AS department,
                p.name AS professor_name,
                CAST(AVG(s.score) AS DOUBLE) AS average_score,
                GROUP_CONCAT(e.content) AS evaluation_comments
            FROM departments d
            JOIN professors p ON d.id = p.department_id
            JOIN lectures l ON p.id = l.professor_id
            JOIN evaluations e ON l.id = e.lecture_id
            JOIN scopes s ON e.id = s.evaluation_id
            GROUP BY d.name, p.name
            ORDER BY d.name, p.name, average_score DESC;
            """, nativeQuery = true)
    List<CourseEvaluationDTO> findLectureEvaluationsWithComments();
}
