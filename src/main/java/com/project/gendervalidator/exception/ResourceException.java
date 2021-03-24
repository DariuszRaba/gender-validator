package com.project.gendervalidator.exception;

public class ResourceException extends RuntimeException{

    public ResourceException(String rootCause){
        super(String.format("There was a problem with %s tokens.",rootCause));
    }
}
