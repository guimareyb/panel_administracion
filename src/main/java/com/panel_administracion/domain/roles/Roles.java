package com.panel_administracion.domain.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Roles")
@Table(name = "roles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean flag;

    public Roles(DataRolesResponse dataRolesResponse){
        this.flag = true;
        this.name = dataRolesResponse.name();
        this.description = dataRolesResponse.description();
    }

    public void deactivateRoles(){
        this.flag = false;
    }

    public void updateRoles(DataRolesUpdate dataRolesUpdate){
        if (dataRolesUpdate.name() != null){
            this.name = dataRolesUpdate.name();
        }
        if (dataRolesUpdate.description() !=null){
            this.description = dataRolesUpdate.description();
        }
    }
}
