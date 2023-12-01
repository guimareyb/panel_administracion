package com.panel_administracion.domain.roles;

import com.panel_administracion.domain.content.DataListContent;

public record DataListRoles(Long id, String name, String description) {

    public DataListRoles(Roles roles){

        this(roles.getId(), roles.getName(), roles.getDescription());
    }
}
