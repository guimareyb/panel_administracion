package com.panel_administracion.domain.content;

import jakarta.validation.constraints.NotNull;

public record DataUpdateContent(

        @NotNull
        Long id,
        String name,
        String description
) {
}
