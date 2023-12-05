package com.panel_administracion.controller;

import com.panel_administracion.domain.content.ContentRepository;
import com.panel_administracion.domain.permission.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<DataPermissionResponse> responseDataPermission(@PathVariable Long id){
        Permission permission = permissionRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataPermissionResponse(permission));
    }

    @GetMapping
    public ResponseEntity<Page<DataPermissionResponse>> listPermission(@PageableDefault(size = 3, sort = "id")Pageable pageable){
        return ResponseEntity.ok(permissionRepository.findByFlagTrue(pageable).map(DataPermissionResponse::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataPermissionResponse> updataPermission (@RequestBody @Valid DataPermissionUpdate dataPermissionUpdate){
        DataPermissionResponse dataPermissionResponse = service.UpdatePermission(dataPermissionUpdate);
        return ResponseEntity.ok(dataPermissionResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletePermission(@PathVariable Long id){
        Permission permission = permissionRepository.getReferenceById(id);
        permission.deactivatePermission();
        return ResponseEntity.noContent().build();
    }
}
