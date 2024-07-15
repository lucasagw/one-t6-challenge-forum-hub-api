package br.com.alura.forum_hub_api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserUpdateData(
        @Positive
        @NotNull
        Long id,

        String name,

        @Email
        String email,

        String password) {
}
