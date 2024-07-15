package br.com.alura.forum_hub_api.domain.course;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseUpdateData(
        @Positive
        @NotNull
        Long id,

        String name,

        Category category) {
}
