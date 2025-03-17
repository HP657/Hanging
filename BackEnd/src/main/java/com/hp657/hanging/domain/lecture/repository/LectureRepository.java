package com.hp657.hanging.domain.lecture.repository;

import com.hp657.hanging.domain.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
