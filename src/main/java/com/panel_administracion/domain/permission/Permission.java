package com.panel_administracion.domain.roles;

import com.panel_administracion.domain.content.Content;
import com.panel_administracion.domain.permission.DataRecordPermission;
import com.panel_administracion.domain.permission.DataUpdatePermission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Permission")
@Table(name = "permissions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean flag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;

    public Permission(DataRecordPermission dataRecordPermission, Content content){
        this.flag = true;
        this.content = content;
        this.name = dataRecordPermission.name();
    }

    public void deactivatePermission(){
        this.flag = false;
    }

    public void updatePermission(DataUpdatePermission dataUpdatePermission){
        if (dataUpdatePermission.name() != null){
            this.name = dataUpdatePermission.name();
        }
    }

}