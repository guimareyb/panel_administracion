package com.panel_administracion.infra.errors;

public class IntegrityValidation extends RuntimeException{
    public IntegrityValidation(String s){
        super(s);

    }

}
