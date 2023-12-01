package com.panel_administracion.domain.roles;

public record DataRolesResponse(Long id, String name, String description) {

    public DataRolesResponse(Roles roles){

        this(roles.getId(), roles.getName(), roles.getDescription());
    }
}
