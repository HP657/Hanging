-- 교수 테이블
CREATE TABLE professors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- 강의 테이블
CREATE TABLE lectures (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    professor_id BIGINT NOT NULL,
    FOREIGN KEY (professor_id) REFERENCES professors(id)
);

-- 평가 테이블
CREATE TABLE evaluations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(1000) NOT NULL,
    lecture_id BIGINT NOT NULL,
    FOREIGN KEY (lecture_id) REFERENCES lectures(id)
);

-- 별점 테이블
CREATE TABLE scopes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    score INTEGER NOT NULL,
    evaluation_id BIGINT NOT NULL,
    FOREIGN KEY (evaluation_id) REFERENCES evaluations(id)
);
