package com.panel_administracion.domain.permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionRepository  extends JpaRepository<Permission, Long> {
    Page<Permission> findByFlagTrue(Pageable pagination);

    //verifica si ya existe un nombre igual
    @Query("""
        SELECT EXISTS(
            SELECT t FROM Permission t
            WHERE t.name =:name
            AND (:id IS NULL OR t.id != :id)
            ) AS duplicateName
        """)
        Boolean findDuplicateName(String name, Long id);

}
