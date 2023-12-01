package com.panel_administracion.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime birthdate;
    private String identificationDocument;
    private String nationality;
    private LocalDateTime registrationDate;
    private Boolean flag;

    public User(DataListUser dataListUser){
        this.flag = true;
        this.name = dataListUser.name();
        this.lastname = dataListUser.lastname();
        this.email = dataListUser.email();
        this.birthdate = dataListUser.birthdate();
        this.identificationDocument = dataListUser.identificationDocument();
        this.nationality = dataListUser.nationality();
        this.registrationDate = dataListUser.registrationDate();
    }

    public void deactivateUser(){
        this.flag = false;
    }

    public void updateUser(DataUpdateUser dataUpdateUser){
        if (dataUpdateUser.name() != null){
            this.name = dataUpdateUser.name();
        }
        if (dataUpdateUser.lastname() != null){
            this.lastname = dataUpdateUser.lastname();
        }
        if (dataUpdateUser.email() != null){
            this.email = dataUpdateUser.email();
        }
        if(dataUpdateUser.birthdate() != null){
            this.birthdate = dataUpdateUser.birthdate();
        }
        if (dataUpdateUser.identificationDocument() != null){
            this.identificationDocument = dataUpdateUser.identificationDocument();
        }
        if (dataUpdateUser.nationality() != null){
            this.nationality = dataUpdateUser.nationality();
        }
        if (dataUpdateUser.registrationDate() != null){
            this.registrationDate = dataUpdateUser.registrationDate();
        }
    }
}
