package com.hp657.hanging.domain.professor.service;

import com.hp657.hanging.domain.professor.dto.ProfessorResponseDto;
import com.hp657.hanging.domain.professor.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<ProfessorResponseDto> getProfessorsByDepartment(String departmentName) {
        return professorRepository.findProfessorsByDepartmentName(departmentName);
    }

}
