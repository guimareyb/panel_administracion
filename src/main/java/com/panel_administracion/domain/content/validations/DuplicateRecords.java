package com.panel_administracion.domain.content.validations;

import com.panel_administracion.domain.content.ContentRepository;
import com.panel_administracion.domain.content.DataContentInsert;
import com.panel_administracion.domain.content.DataContentUpdate;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateRecords implements ContentValidator {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public void validate(DataContentInsert dataContentInsert, DataContentUpdate dataContentUpdate){
        Boolean duplicateName = null;
        Boolean duplicateDescription = null;

        if (dataContentInsert != null){
            duplicateName = contentRepository.findDuplicateName(dataContentInsert.name(), null);
            duplicateDescription = contentRepository.findDuplicateDescription(dataContentInsert.description(), null);
        }

        if (dataContentUpdate != null){
            duplicateName = contentRepository.findDuplicateName(dataContentUpdate.name(),dataContentUpdate.id());
            duplicateDescription = contentRepository.findDuplicateDescription(dataContentUpdate.description(),dataContentUpdate.id());
        }

        if (duplicateName){
            throw new ValidationException("There is already a content with this name");
        }
        if (duplicateDescription){
            throw new ValidationException("There is already a content with this description");
        }

    }
}
