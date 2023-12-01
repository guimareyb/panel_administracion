package com.panel_administracion.domain.roles;

import jakarta.validation.constraints.NotBlank;

public record DataRolesInsert(
        @NotBlank
        String name,
        @NotBlank
        String description
) {
}
