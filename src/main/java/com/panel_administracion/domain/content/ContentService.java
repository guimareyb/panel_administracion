package com.panel_administracion.domain.content;

import com.panel_administracion.domain.content.validations.ContentValidator;
import com.panel_administracion.domain.permission.DataPermissionResponse;
import com.panel_administracion.domain.permission.Permission;
import com.panel_administracion.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private List<ContentValidator> validators;

    public DataContentResponse insertContent(DataContentInsert dataContentInsert){

        validators.forEach(v -> v.validate(dataContentInsert, null));

        Content content = contentRepository.save(new Content(dataContentInsert));

        return new DataContentResponse(content);
    }
}
