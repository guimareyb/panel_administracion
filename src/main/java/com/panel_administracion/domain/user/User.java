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

    public User(DataUserResponse dataListUser){
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
