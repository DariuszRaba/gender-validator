package com.project.gendervalidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProvidedDataException extends RuntimeException{
    public ProvidedDataException(){
        super("There is probably wrong data input.");
    }
}
