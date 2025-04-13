package com.hp657.hanging.domain.evaluation.service;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.department.repository.DepartmentRepository;
import com.hp657.hanging.domain.evaluation.dto.CourseEvaluationDTO;
import com.hp657.hanging.domain.evaluation.dto.EvaluationRequestDto;
import com.hp657.hanging.domain.evaluation.dto.LectureEvaluationDTO;
import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import com.hp657.hanging.domain.evaluation.repository.EvaluationRepository;
import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.lecture.repository.LectureRepository;
import com.hp657.hanging.domain.professor.entity.Professor;
import com.hp657.hanging.domain.professor.repository.ProfessorRepository;
import com.hp657.hanging.domain.scope.repository.ScopeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Department department = departmentRepository.findByName(requestDto.getDepartmentName()).get();

        Professor professor = professorRepository.findByNameAndDepartment(requestDto.getProfessorName(), department)
                .orElseGet(() -> professorRepository.save(requestDto.toProfessor(department)));

        Lecture lecture = lectureRepository.findByTitle(requestDto.getLectureTitle())
                .orElseGet(() -> lectureRepository.save(requestDto.toLecture(professor)));

        Evaluation evaluation = evaluationRepository.save(requestDto.toEvaluation(lecture));

        scopeRepository.save(requestDto.toScope(evaluation));
    }

    public List<LectureEvaluationDTO> getLectureEvaluations() {
        return  evaluationRepository.findLectureEvaluationsNative();
    }

    public List<CourseEvaluationDTO> getCourseEvaluationsWithComments() {
        return evaluationRepository.findLectureEvaluationsWithComments();
    }
}
