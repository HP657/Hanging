package com.hp657.hanging.domain.lecture.entity;

import com.hp657.hanging.domain.professor.entity.Professor;
import jakarta.persistence.*;
import lombok.*;

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
    private String title;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false) // ✅ ManyToOne 관계에서 JoinColumn 사용 가능
    private Professor professor;
}
