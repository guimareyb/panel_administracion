package com.panel_administracion.domain.permission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRecordPermission(

        @NotBlank
        String name,
        @NotNull
        Long contentId

) {
}
