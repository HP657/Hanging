INSERT INTO professors (name) VALUES ('김철수');
INSERT INTO professors (name) VALUES ('이영희');

-- 강의 데이터
INSERT INTO lectures (title, professor_id) VALUES ('객체지향 프로그래밍', 1);
INSERT INTO lectures (title, professor_id) VALUES ('데이터베이스 기초', 2);

-- 평가 데이터
INSERT INTO evaluations (content, lecture_id) VALUES ('강의가 이해하기 쉬워요!', 1);
INSERT INTO evaluations (content, lecture_id) VALUES ('학생을 잘 배려해 줍니다.', 2);

-- 별점 데이터
INSERT INTO scopes (score, evaluation_id) VALUES (5, 1);
INSERT INTO scopes (score, evaluation_id) VALUES (4, 1);
INSERT INTO scopes (score, evaluation_id) VALUES (3, 2);
INSERT INTO scopes (score, evaluation_id) VALUES (5, 2);