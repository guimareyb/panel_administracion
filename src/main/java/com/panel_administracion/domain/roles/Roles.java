package com.panel_administracion.domain.roles;

import com.panel_administracion.domain.content.DataUpdateContent;
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

    public Roles(DataListRoles dataListRoles){
        this.flag = true;
        this.name = dataListRoles.name();
        this.description = dataListRoles.description();
    }

    public void deactivateRoles(){
        this.flag = false;
    }

    public void updateRoles(DataUpdateRoles dataUpdateRoles){
        if (dataUpdateRoles.name() != null){
            this.name = dataUpdateRoles.name();
        }
        if (dataUpdateRoles.description() !=null){
            this.description = dataUpdateRoles.description();
        }
    }
}
