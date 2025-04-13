package com.hp657.hanging.domain.evaluation.dto;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.professor.entity.Professor;
import com.hp657.hanging.domain.scope.entity.Scope;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationRequestDto {
    private String departmentName;
    private String professorName;
    private String lectureTitle;
    private String evaluationContent;
    private Double rating;

    public Professor toProfessor(Department department) {
        Professor professor = new Professor();
        professor.setName(professorName);
        professor.setDepartment(department);
        return professor;
    }

    public Lecture toLecture(Professor professor) {
        Lecture lecture = new Lecture();
        lecture.setTitle(lectureTitle);
        lecture.setProfessor(professor);
        return lecture;
    }

    public Evaluation toEvaluation(Lecture lecture) {
        Evaluation evaluation = new Evaluation();
        evaluation.setLecture(lecture);
        evaluation.setContent(evaluationContent);
        evaluation.setTimestamp(LocalDateTime.now());
        return evaluation;
    }

    public Scope toScope(Evaluation evaluation) {
        Scope scope = new Scope();
        scope.setEvaluation(evaluation);
        scope.setScore(rating);
        return scope;
    }
}
