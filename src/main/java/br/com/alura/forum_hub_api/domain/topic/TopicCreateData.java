package br.com.alura.forum_hub_api.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TopicCreateData(
        @Positive
        @NotNull
        Long authorId,

        @Positive
        @NotNull
        Long courseId,

        @NotBlank
        String title,

        @NotBlank
        String message) {
}
