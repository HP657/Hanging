package com.hp657.hanging.domain.evaluation.entity;

import com.hp657.hanging.domain.lecture.entity.Lecture;
import com.hp657.hanging.domain.professor.entity.Professor;
import com.hp657.hanging.domain.scope.entity.Scope;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Scope> scopes;
}
