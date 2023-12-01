package com.panel_administracion.domain.user;

import java.time.LocalDateTime;

public record DataUserResponse(Long id, String name, String lastname, String email, LocalDateTime birthdate,
                               String identificationDocument, String nationality, LocalDateTime registrationDate ) {

    public DataUserResponse(User user){
        this(user.getId(), user.getName(), user.getLastname(), user.getEmail(), user.getBirthdate(), user.getIdentificationDocument(),
                user.getNationality(), user.getRegistrationDate());
    }
}
