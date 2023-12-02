package com.panel_administracion.controller;

import com.panel_administracion.domain.content.ContentRepository;
import com.panel_administracion.domain.permission.DataPermissionInsert;
import com.panel_administracion.domain.permission.DataPermissionResponse;
import com.panel_administracion.domain.permission.Permission;
import com.panel_administracion.domain.permission.PermissionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ContentRepository contentRepository;

    @PostMapping
    public ResponseEntity<DataPermissionResponse> insertPermission(@Valid @RequestBody DataPermissionInsert dataPermissionInsert, UriComponentsBuilder uriComponentsBuilder){
        Permission  permission = permissionRepository.save(new Permission(dataPermissionInsert));
        DataPermissionResponse dataPermissionResponse = new DataPermissionResponse(permission);
        URI url = uriComponentsBuilder.path("/permission/{id}").buildAndExpand(permission.getId()).toUri();
        return ResponseEntity.created(url).body(dataPermissionResponse);
    }


}
