package com.hp657.hanging.global.common;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiPath {
    public static final String BASE_PATH = "/api";
    public static final String PROFESSOR_PATH = BASE_PATH + "/professor";
    public static final String EVALUATION_PATH = BASE_PATH + "/evaluation";
    public static final String SCOPE_PATH = BASE_PATH + "/scope";
    public static final String VISITANT_PATH = BASE_PATH + "/visitant";

    public static String H2_PATH;

    @Value("${spring.h2.console.path}")
    private String h2Path;

    @PostConstruct
    public void init() {
        H2_PATH = h2Path;
    }
}
