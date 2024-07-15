CREATE TABLE answers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    topic_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_solution BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_answers_topic_id FOREIGN KEY (topic_id) REFERENCES topics(id),
    CONSTRAINT fk_answers_author_id FOREIGN KEY (author_id) REFERENCES users(id)
);
