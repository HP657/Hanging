package com.hp657.hanging.domain.department.controller;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.department.service.DepartmentService;
import com.hp657.hanging.global.common.ApiPath;
import com.hp657.hanging.global.common.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPath.DEPARTMENT_PATH)
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Response<List<Department>>> getDepartment() {
        return ResponseEntity.ok(new Response<>(HttpStatus.OK,departmentService.getDepartment()));
    }
}
