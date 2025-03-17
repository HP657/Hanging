package com.hp657.hanging.global.common;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiPath {
    public static final String BASE_PATH = "/api";

    public static String H2_PATH;

    @Value("${spring.h2.console.path}")
    private String h2Path;

    @PostConstruct
    public void init() {
        H2_PATH = h2Path;
    }
}
