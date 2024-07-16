package br.com.alura.forum_hub_api.domain.topic;

import java.time.LocalDateTime;

public record TopicListData(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        Status status,
        String authorName,
        String courseName) {

    public TopicListData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(),
                topic.getCreatedAt(), topic.getStatus(),
                topic.getUser().getName(), topic.getCourse().getName());
    }

}
