package com.hp657.hanging.domain.lecture.service;

import com.hp657.hanging.domain.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public List<String> getLecturesByProfessor(String departmentName, String professorName) {
        return lectureRepository.findLecturesByDepartmentAndProfessor(departmentName, professorName);
    }
}
