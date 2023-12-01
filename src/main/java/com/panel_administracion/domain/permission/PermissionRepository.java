package com.panel_administracion.domain.permission;

import com.panel_administracion.domain.content.Content;
import com.panel_administracion.domain.roles.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository  extends JpaRepository<Permission, Long> {
    Page<Content> findByFlagTrue(Pageable pagination);
}
