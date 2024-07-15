package br.com.alura.forum_hub_api.domain.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRegistrationData(
        @NotBlank
        String name,

        @NotNull
        Category category) {
}
