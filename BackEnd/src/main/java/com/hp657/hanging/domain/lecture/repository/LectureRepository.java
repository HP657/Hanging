package com.hp657.hanging.domain.lecture.repository;

import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findByTitle(String title);
}
