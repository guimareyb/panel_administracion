package com.panel_administracion.domain.permission;

import jakarta.validation.constraints.NotNull;

public record DataPermissionUpdate(
        @NotNull
        Long id,
        String name
) {
}
