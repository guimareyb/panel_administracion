package com.panel_administracion.domain.permission;

import com.panel_administracion.domain.roles.Permission;

public record DataListPermission(Long id, Long contentId, String name) {

    public DataListPermission(Permission permission){
        this(permission.getId(), permission.getContent().getId(), permission.getName());
    }
}
