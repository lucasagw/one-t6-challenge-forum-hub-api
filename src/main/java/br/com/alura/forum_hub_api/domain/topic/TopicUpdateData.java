package br.com.alura.forum_hub_api.domain.topic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TopicUpdateData(
        @Positive
        @NotNull
        Long id,

        @Positive
        Long authorId,

        @Positive
        Long courseId,

        String title,

        String message,

        Status status) {
}
