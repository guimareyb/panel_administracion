package com.panel_administracion.domain.roles;

import jakarta.validation.constraints.NotNull;

public record DataUpdateRoles(
    @NotNull
    Long id,
    String name,
    String description
) {
}
