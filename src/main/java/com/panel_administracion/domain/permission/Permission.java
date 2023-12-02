package com.panel_administracion.domain.permission;

import com.panel_administracion.domain.content.Content;
import com.panel_administracion.domain.permission.DataPermissionInsert;
import com.panel_administracion.domain.permission.DataPermissionUpdate;
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

    public Permission(DataPermissionInsert dataPermissionInsert, Content content){
        this.flag = true;
        this.content = content;
        this.name = dataPermissionInsert.name();
    }

    public void deactivatePermission(){
        this.flag = false;
    }

    public void updatePermission(DataPermissionUpdate dataUpdatePermission){
        if (dataUpdatePermission.name() != null){
            this.name = dataUpdatePermission.name();
        }
    }

}