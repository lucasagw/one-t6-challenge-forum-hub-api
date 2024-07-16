package br.com.alura.forum_hub_api.domain.topic;

import jakarta.validation.constraints.Positive;

public record TopicUpdateData(
        @Positive
        Long courseId,

        String title,

        String message,

        Status status) {
}
