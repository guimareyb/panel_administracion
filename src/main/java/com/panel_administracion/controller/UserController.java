package com.panel_administracion.controller;

import com.panel_administracion.domain.user.*;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<DataUserResponse> insertUser(@Valid @RequestBody DataUserInsert dataUserInsert, UriComponentsBuilder uriComponentsBuilder){
        User user = userRepository.save(new User(dataUserInsert));
        DataUserResponse dataUserResponse = new DataUserResponse(user);
        URI url = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(dataUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataUserResponse> responseDataUser(@PathVariable Long id){
        User user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataUserResponse(user));
    }

    @GetMapping
    public ResponseEntity<Page<DataUserResponse>> listUser(@PageableDefault(size = 3, sort = "id")Pageable pageable){
        return ResponseEntity.ok(userRepository.findByFlagTrue(pageable).map(DataUserResponse::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataUserResponse> updateUser(@RequestBody @Valid DataUserUpdate dataUserUpdate){
        User user = userRepository.getReferenceById(dataUserUpdate.id());
        user.updateUser(dataUserUpdate);
        DataUserResponse dataUserResponse = new DataUserResponse(user);
        return ResponseEntity.ok(dataUserResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        User user = userRepository.getReferenceById(id);
        user.deactivateUser();
        return ResponseEntity.noContent().build();
    }

}
