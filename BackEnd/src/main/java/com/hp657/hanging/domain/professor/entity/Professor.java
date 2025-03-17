package com.hp657.hanging.domain.professor.entity;

import com.hp657.hanging.domain.lecture.entity.Lecture;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures;
}
