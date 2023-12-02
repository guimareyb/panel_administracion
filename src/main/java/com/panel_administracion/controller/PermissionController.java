package com.panel_administracion.controller;

import com.panel_administracion.domain.content.ContentRepository;
import com.panel_administracion.domain.permission.*;
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

    @Autowired
    private PermissionService service;

    @PostMapping
    public ResponseEntity<DataPermissionResponse> insertPermission(@Valid @RequestBody DataPermissionInsert dataPermissionInsert, UriComponentsBuilder uriComponentsBuilder){
        DataPermissionResponse dataPermissionResponse = service.insertPermission(dataPermissionInsert);
        URI url = uriComponentsBuilder.path("/permission/{id}").buildAndExpand(dataPermissionResponse.id()).toUri();
        return ResponseEntity.created(url).body(dataPermissionResponse);
    }


}
