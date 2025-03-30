package com.hp657.hanging.domain.evaluation.controller;

import com.hp657.hanging.domain.evaluation.dto.CourseEvaluationDTO;
import com.hp657.hanging.domain.evaluation.dto.EvaluationRequestDto;
import com.hp657.hanging.domain.evaluation.dto.LectureEvaluationDTO;
import com.hp657.hanging.domain.evaluation.service.EvaluationService;
import com.hp657.hanging.global.common.ApiPath;
import com.hp657.hanging.global.common.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPath.EVALUATION_PATH)
@RequiredArgsConstructor
public class EvaluationController {
    private final EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Response<String>> submitEvaluation(@RequestBody EvaluationRequestDto dto) {
        evaluationService.submitEvaluation(dto);
        return ResponseEntity.ok(new Response<>(HttpStatus.OK, "평가가 성공적으로 제출되었습니다."));
    }

    @GetMapping("/all/professor/ranking")
    public ResponseEntity<Response<List<LectureEvaluationDTO>>> getAllProfessorScope() {
        return ResponseEntity.ok(new Response<>(HttpStatus.OK, evaluationService.getLectureEvaluations()));
    }

    @GetMapping("/all/professor/review")
    public ResponseEntity<Response<List<CourseEvaluationDTO>>> getAllProfessorReview() {
        return ResponseEntity.ok(new Response<>(HttpStatus.OK, evaluationService.getCourseEvaluationsWithComments()));
    }
}
