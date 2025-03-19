package com.hp657.hanging.domain.evaluation.service;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.department.repository.DepartmentRepository;
import com.hp657.hanging.domain.evaluation.dto.EvaluationRequestDto;
import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import com.hp657.hanging.domain.evaluation.repository.EvaluationRepository;
import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.lecture.repository.LectureRepository;
import com.hp657.hanging.domain.professor.entity.Professor;
import com.hp657.hanging.domain.professor.repository.ProfessorRepository;
import com.hp657.hanging.domain.scope.entity.Scope;
import com.hp657.hanging.domain.scope.repository.ScopeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final DepartmentRepository departmentRepository;
    private final ProfessorRepository professorRepository;
    private final LectureRepository lectureRepository;
    private final EvaluationRepository evaluationRepository;
    private final ScopeRepository scopeRepository;

    @Transactional
    public void submitEvaluation(EvaluationRequestDto requestDto) {
        // 학과 찾기 (없으면 생성)
        Department department = departmentRepository.findByName(requestDto.getDepartmentName())
                .orElseGet(() -> {
                    Department newDepartment = new Department();
                    newDepartment.setName(requestDto.getDepartmentName());
                    return departmentRepository.save(newDepartment);
                });

        // 교수 찾기 (없으면 생성)
        Professor professor = professorRepository.findByNameAndDepartment(requestDto.getProfessorName(), department)
                .orElseGet(() -> {
                    Professor newProfessor = new Professor();
                    newProfessor.setName(requestDto.getProfessorName());
                    newProfessor.setDepartment(department);
                    return professorRepository.save(newProfessor);
                });

        // 강의 찾기 (없으면 생성)
        Lecture lecture = lectureRepository.findByTitle(requestDto.getLectureTitle())
                .orElseGet(() -> {
                    Lecture newLecture = new Lecture();
                    newLecture.setTitle(requestDto.getLectureTitle());
                    // lecture 객체에 교수님을 추가
                    newLecture.setProfessor(professor);
                    return lectureRepository.save(newLecture);
                });


        // 평가 등록
        Evaluation evaluation = new Evaluation();
        evaluation.setLecture(lecture);
        evaluation.setContent(requestDto.getEvaluationContent());
        evaluation = evaluationRepository.save(evaluation);

        // 별점 등록
        Scope scope = new Scope();
        scope.setEvaluation(evaluation);
        scope.setScore(requestDto.getRating());
        scopeRepository.save(scope);
    }
}
