package com.hp657.hanging.domain.lecture.controller;

import com.hp657.hanging.domain.lecture.service.LectureService;
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
@RequestMapping(ApiPath.LECTURE_PATH)
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @GetMapping
    public ResponseEntity<Response<List<String>>> getLecturesByProfessor(
            @RequestParam String departmentName,
            @RequestParam String professorName) {
        return ResponseEntity.ok(new Response<>(HttpStatus.OK, lectureService.getLecturesByProfessor(departmentName, professorName)));
    }
}
