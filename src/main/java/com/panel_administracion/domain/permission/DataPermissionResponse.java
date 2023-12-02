package com.panel_administracion.domain.permission;


public record DataPermissionResponse(Long id, Long contentId, String name) {

    public DataPermissionResponse(Permission permission){
        this(permission.getId(), permission.getContent().getId(), permission.getName());
    }
}
