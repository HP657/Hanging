package com.hp657.hanging.domain.evaluation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureEvaluationDTO {
    private String department;
    private String professorName;
    private Double averageScore;
}
