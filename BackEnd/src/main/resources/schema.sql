-- 학과(Department) 테이블
CREATE TABLE departments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- 교수(Professor) 테이블 (학과 관계 추가)
CREATE TABLE professors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    department_id BIGINT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);

-- 강의(Lecture) 테이블
CREATE TABLE lectures (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

-- 강의-교수 관계 테이블 (N:M 해결)
CREATE TABLE lecture_professor (
    lecture_id BIGINT NOT NULL,
    professor_id BIGINT NOT NULL,
    PRIMARY KEY (lecture_id, professor_id),
    FOREIGN KEY (lecture_id) REFERENCES lectures(id) ON DELETE CASCADE,
    FOREIGN KEY (professor_id) REFERENCES professors(id) ON DELETE CASCADE
);

-- 평가(Evaluation) 테이블
CREATE TABLE evaluations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(1000) NOT NULL,
    lecture_id BIGINT NOT NULL,
    FOREIGN KEY (lecture_id) REFERENCES lectures(id) ON DELETE CASCADE
);

-- 별점(Scope) 테이블
CREATE TABLE scopes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    score INTEGER NOT NULL,
    evaluation_id BIGINT NOT NULL,
    FOREIGN KEY (evaluation_id) REFERENCES evaluations(id) ON DELETE CASCADE
);
