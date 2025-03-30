package com.hp657.hanging.domain.lecture.repository;

import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findByTitle(String title);

    @Query("SELECT l.title FROM Lecture l WHERE l.professor.department.name = :departmentName AND l.professor.name = :professorName")
    List<String> findLecturesByDepartmentAndProfessor(String departmentName, String professorName);

}
