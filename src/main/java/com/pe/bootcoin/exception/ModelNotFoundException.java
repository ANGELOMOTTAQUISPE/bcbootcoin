package com.pe.bootcoin.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String mensaje){
        super(mensaje);
    }
}
