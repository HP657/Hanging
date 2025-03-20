package com.hp657.hanging.domain.professor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hp657.hanging.domain.department.entity.Department;
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

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnore
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "lecture_professor",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    private List<Lecture> lectures;
}
