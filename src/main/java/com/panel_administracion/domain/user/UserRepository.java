package com.panel_administracion.domain.user;

import com.panel_administracion.domain.content.Content;
import com.panel_administracion.domain.roles.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByFlagTrue(Pageable pagination);
}

