package com.panel_administracion.domain.permission;

import com.panel_administracion.domain.content.Content;
import com.panel_administracion.domain.content.ContentRepository;
import com.panel_administracion.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ContentRepository contentRepository;

    public DataPermissionResponse insertPermission(DataPermissionInsert dataPermissionInsert){
        if (contentRepository.findById(dataPermissionInsert.contentId()).isEmpty()){
            throw new IntegrityValidation("This id for the content was not found");
        }
        Content content = contentRepository.findById(dataPermissionInsert.contentId()).get();
        Permission permission = permissionRepository.save(new Permission(dataPermissionInsert, content));
        return new DataPermissionResponse(permission);
    }

}
