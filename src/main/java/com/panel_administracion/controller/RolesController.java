package com.panel_administracion.controller;

import com.panel_administracion.domain.roles.*;
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
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @PostMapping
    public ResponseEntity<DataRolesResponse> insertRol(@Valid @RequestBody DataRolesInsert dataRolesInsert, UriComponentsBuilder uriComponentsBuilder){
        Roles roles = rolesRepository.save(new Roles(dataRolesInsert));
        DataRolesResponse dataRolesResponse = new DataRolesResponse(roles);
        URI url = uriComponentsBuilder.path("/roles/{id}").buildAndExpand(roles.getId()).toUri();
        return ResponseEntity.created(url).body(dataRolesResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataRolesResponse> responseDataRoles(@PathVariable Long id){
        Roles roles = rolesRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataRolesResponse(roles));
    }

    @GetMapping
    public ResponseEntity<Page<DataRolesResponse>> listRoles(@PageableDefault(size = 3, sort = "id")Pageable pageable){
        return ResponseEntity.ok(rolesRepository.findByFlagTrue(pageable).map(DataRolesResponse::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataRolesResponse> updateRoles (@RequestBody @Valid DataRolesUpdate dataRolesUpdate){
        Roles roles = rolesRepository.getReferenceById(dataRolesUpdate.id());
        roles.updateRoles(dataRolesUpdate);
        DataRolesResponse dataRolesResponse = new DataRolesResponse(roles);
        return ResponseEntity.ok(dataRolesResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteRoles(@PathVariable Long id){
        Roles roles = rolesRepository.getReferenceById(id);
        roles.deactivateRoles();
        return ResponseEntity.noContent().build();
    }

}


