package com.panel_administracion.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUpdateUser(
        @NotNull
        Long id,
        String name,
        String lastname,
        String email,
        LocalDateTime birthdate,
        String identificationDocument,
        String nationality,
        LocalDateTime registrationDate
) {
}
