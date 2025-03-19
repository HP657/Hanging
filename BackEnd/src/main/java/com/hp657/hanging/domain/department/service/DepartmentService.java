package com.hp657.hanging.domain.department.service;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getDepartment() {
        return departmentRepository.findAllByOrderByIdAsc();
    }
}
