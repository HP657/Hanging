package com.hp657.hanging.domain.professor.controller;

import com.hp657.hanging.domain.professor.dto.ProfessorResponseDto;
import com.hp657.hanging.domain.professor.service.ProfessorService;
import com.hp657.hanging.global.common.ApiPath;
import com.hp657.hanging.global.common.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPath.PROFESSOR_PATH)
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("/by/department")
    public ResponseEntity<Response<List<ProfessorResponseDto>>> getProfessorsByDepartment(@RequestParam String departmentName) {
        return ResponseEntity.ok(new Response<>(HttpStatus.OK, professorService.getProfessorsByDepartment(departmentName)));
    }
}
