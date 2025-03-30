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

    @OneToMany(mappedBy = "professor")
    private List<Lecture> lectures;
}
