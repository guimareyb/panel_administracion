package com.panel_administracion.domain.content.validations;

import com.panel_administracion.domain.content.DataContentInsert;
import com.panel_administracion.domain.content.DataContentUpdate;

public interface ContentValidator {

    public void validate(DataContentInsert dataContentInsert, DataContentUpdate dataContentUpdate);

}
