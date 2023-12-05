package com.panel_administracion.domain.permission.validations;

import com.panel_administracion.domain.permission.DataPermissionInsert;
import com.panel_administracion.domain.permission.DataPermissionUpdate;

public interface PermissionValidator {

    public void validate(DataPermissionInsert dataPermissionInsert, DataPermissionUpdate dataPermissionUpdate);
}
