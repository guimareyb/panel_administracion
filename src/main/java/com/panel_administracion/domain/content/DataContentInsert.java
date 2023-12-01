package com.panel_administracion.domain.content;

import jakarta.validation.constraints.NotBlank;

public record DataContentInsert(

        @NotBlank
        String name,
        @NotBlank
        String description
) {   //data registros contenidos

}