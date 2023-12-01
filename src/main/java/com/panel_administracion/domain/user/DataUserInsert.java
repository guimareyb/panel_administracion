package com.panel_administracion.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUserInsert(
        @NotBlank
        String name,
        @NotBlank
        String lastname,
        @Email
        @NotBlank
        String email,
        @NotNull
        LocalDateTime birthdate,
        @NotBlank
        String identificationDocument,
        @NotBlank
        String nationality,
        @NotNull
        LocalDateTime registrationDate

) {
}
