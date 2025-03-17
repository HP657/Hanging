package com.hp657.hanging.domain.lecture.entity;

import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import com.hp657.hanging.domain.professor.entity.Professor;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "lectures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // 강의명

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;
}
