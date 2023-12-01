package com.panel_administracion.domain.content;

import jakarta.validation.constraints.NotNull;

public record DataContentUpdate(

        @NotNull
        Long id,
        String name,
        String description
) {
}
