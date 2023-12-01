package com.panel_administracion.domain.roles;

import com.panel_administracion.domain.content.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Page<Content> findByFlagTrue(Pageable pagination);
}
