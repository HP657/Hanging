package com.hp657.hanging.domain.evaluation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEvaluationDTO {
    private String department;
    private String professorName;
    private String lectureTitle;
    private Double score;
    private String evaluationComment;
}
