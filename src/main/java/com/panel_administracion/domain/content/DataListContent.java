package com.panel_administracion.domain.content;

public record DataListContent(Long id, String name, String description) {

    public DataListContent(Content content){
        this(content.getId(), content.getName(), content.getDescription());
        }
}

