package com.panel_administracion.domain.content;

public record DataContentResponse(Long id, String name, String description) {

    public DataContentResponse(Content content){
        this(content.getId(), content.getName(), content.getDescription());
        }
}

