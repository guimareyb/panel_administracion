package com.panel_administracion.domain.permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository  extends JpaRepository<Permission, Long> {
    Page<Permission> findByFlagTrue(Pageable pagination);
}
