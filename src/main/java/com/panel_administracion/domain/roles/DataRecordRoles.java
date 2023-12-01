package com.panel_administracion.domain.roles;

import jakarta.validation.constraints.NotBlank;

public record DataRecordRoles(
        @NotBlank
        String name,
        @NotBlank
        String description
) {
}
