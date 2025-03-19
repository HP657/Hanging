package com.hp657.hanging.domain.evaluation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
