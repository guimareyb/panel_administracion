package com.panel_administracion.domain.user;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "User")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private LocalDate birthdate;
    private String identificationDocument;
    private String nationality;
    private LocalDate registrationDate;
    private Boolean flag;

    public User(@Valid DataUserInsert dataUserInsert){
        this.flag = true;
        this.name = dataUserInsert.name();
        this.lastname = dataUserInsert.lastname();
        this.email = dataUserInsert.email();
        this.birthdate = dataUserInsert.birthdate();
        this.identificationDocument = dataUserInsert.identificationDocument();
        this.nationality = dataUserInsert.nationality();
        this.registrationDate = dataUserInsert.registrationDate();
    }

    public void deactivateUser(){
        this.flag = false;
    }

    public void updateUser(DataUserUpdate dataUserUpdate){
        if (dataUserUpdate.name() != null){
            this.name = dataUserUpdate.name();
        }
        if (dataUserUpdate.lastname() != null){
            this.lastname = dataUserUpdate.lastname();
        }
        if (dataUserUpdate.email() != null){
            this.email = dataUserUpdate.email();
        }
        if(dataUserUpdate.birthdate() != null){
            this.birthdate = dataUserUpdate.birthdate();
        }
        if (dataUserUpdate.identificationDocument() != null){
            this.identificationDocument = dataUserUpdate.identificationDocument();
        }
        if (dataUserUpdate.nationality() != null){
            this.nationality = dataUserUpdate.nationality();
        }
        if (dataUserUpdate.registrationDate() != null){
            this.registrationDate = dataUserUpdate.registrationDate();
        }
    }
}
