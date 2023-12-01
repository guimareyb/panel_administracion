package com.panel_administracion.domain.permission;

import jakarta.validation.constraints.NotNull;

public record DataUpdatePermission(
        @NotNull
        Long id,
        String name
) {
}
