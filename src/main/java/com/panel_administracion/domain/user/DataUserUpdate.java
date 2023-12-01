package com.panel_administracion.domain.user;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUserUpdate(
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
