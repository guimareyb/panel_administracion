package com.panel_administracion.controller;

import com.panel_administracion.domain.user.DataUserInsert;
import com.panel_administracion.domain.user.DataUserResponse;
import com.panel_administracion.domain.user.User;
import com.panel_administracion.domain.user.UserRepository;
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
}
