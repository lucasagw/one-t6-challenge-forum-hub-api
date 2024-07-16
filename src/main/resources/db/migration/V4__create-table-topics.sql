CREATE TABLE topics (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       author_id BIGINT NOT NULL,
                       course_id BIGINT NOT NULL,
                       title VARCHAR(100) NOT NULL,
                       message VARCHAR(300) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       deactivated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       status VARCHAR(50) NOT NULL,
                       CONSTRAINT fk_topics_author_id FOREIGN KEY (author_id) REFERENCES users(id),
                       CONSTRAINT fk_topics_course_id FOREIGN KEY (course_id) REFERENCES courses(id)
);
