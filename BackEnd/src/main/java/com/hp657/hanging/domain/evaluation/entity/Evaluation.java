package com.hp657.hanging.domain.evaluation.entity;

import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.professor.entity.Professor;
import com.hp657.hanging.domain.scope.entity.Scope;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @Column
    private LocalDateTime timestamp;
}
