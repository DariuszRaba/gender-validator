package com.project.gendervalidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ResourceException extends RuntimeException{

    public ResourceException(String rootCause){
        super(String.format("There was a problem with %s tokens.",rootCause));
    }
}
