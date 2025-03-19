package com.hp657.hanging.domain.scope.entity;

import com.hp657.hanging.domain.evaluation.entity.Evaluation;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "scopes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double score;

    @ManyToOne
    @JoinColumn(name = "evaluation_id", nullable = false)
    private Evaluation evaluation;
}
