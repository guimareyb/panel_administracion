package com.panel_administracion.domain.user;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataUserUpdate(
        @NotNull
        Long id,
        String name,
        String lastname,
        String email,
        LocalDate birthdate,
        String identificationDocument,
        String nationality,
        LocalDate registrationDate
) {
}
