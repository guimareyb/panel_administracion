package com.panel_administracion.domain.user;

import java.time.LocalDate;


public record DataUserResponse(Long id, String name, String lastname, String email, LocalDate birthdate,
                               String identificationDocument, String nationality, LocalDate registrationDate ) {

    public DataUserResponse(User user){
        this(user.getId(), user.getName(), user.getLastname(), user.getEmail(), user.getBirthdate(), user.getIdentificationDocument(),
                user.getNationality(), user.getRegistrationDate());
    }
}
