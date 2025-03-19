package com.hp657.hanging.global.config;

import com.hp657.hanging.domain.department.entity.Department;
import com.hp657.hanging.domain.department.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseInitializer {
    @Bean
    public CommandLineRunner initDepartment(DepartmentRepository departmentRepository) {
        return args -> {
            departmentRepository.save(new Department("전기전자공학과"));
            departmentRepository.save(new Department("스마트전기전자공학과"));
            departmentRepository.save(new Department("기계공학과"));
            departmentRepository.save(new Department("스마트기계공학과"));
            departmentRepository.save(new Department("스마트소프트웨어학과"));
        };
    }
}
