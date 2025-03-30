package com.hp657.hanging.domain.department.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hp657.hanging.domain.professor.entity.Professor;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private List<Professor> professors = new ArrayList<>();

    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
    }
}
