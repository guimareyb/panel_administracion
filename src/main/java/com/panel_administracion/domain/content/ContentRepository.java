package com.panel_administracion.domain.content;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    Page<Content> findByFlagTrue(Pageable pagination);

    //verifica si ya existe un nombre igual
    @Query("""
        SELECT EXISTS(
            SELECT c FROM Content c
            WHERE c.name =: name
            AND (:id IS NULL OR c.id != :id)            
        ) AS duplicateName
    """)
    Boolean findDuplicateName(String name, Long id);

    //verifica si ya existe una descripcion igual
    @Query("""
        SELECT EXISTS(
            SELECT c FROM Content c
            WHERE c.description =: description
            AND (:id IS NULL OR c.id != :id)
        ) AS duplicateDescription
    """)
    Boolean findDuplicateDescription(String description, Long id);


    List<Content> findByName(String name);
}
