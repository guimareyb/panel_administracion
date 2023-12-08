package com.panel_administracion.domain.permission.validations;

import com.panel_administracion.domain.permission.DataPermissionInsert;
import com.panel_administracion.domain.permission.DataPermissionUpdate;
import com.panel_administracion.domain.permission.PermissionRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateRecords implements PermissionValidator{

    @Autowired
    private PermissionRepository repository;

    @Override
    public void validate(DataPermissionInsert dataPermissionInsert, DataPermissionUpdate dataPermissionUpdate){
        Boolean duplicateName = null;

        if (dataPermissionInsert != null){
            duplicateName = repository.findDuplicateName(dataPermissionInsert.name(), null);
        }

        if (dataPermissionUpdate != null){
            duplicateName = repository.findDuplicateName(dataPermissionUpdate.name(),dataPermissionUpdate.id());
        }

        if(duplicateName){
            throw new ValidationException("There is already a permission with this name.");
        }

    }
}
