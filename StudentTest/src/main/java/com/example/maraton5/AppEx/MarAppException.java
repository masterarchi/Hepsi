package com.example.maraton5.AppEx;

import lombok.Getter;

@Getter
public class MarAppException extends RuntimeException {

    private ErrorType errorType;

    public MarAppException (ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public MarAppException (ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }








}
