package com.hp657.hanging.domain.professor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfessorResponseDto {
    private Long departmentId;
    private String departmentName;
    private Long professorId;
    private String professorName;
}
