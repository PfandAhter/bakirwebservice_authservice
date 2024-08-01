package com.bws.authservice.exceptions;

import lombok.Getter;

public class PasswordNotMatchedException extends Exception{

    @Getter
    private String message;

    public PasswordNotMatchedException(){
        super();
        this.message = null;
    }
    public PasswordNotMatchedException(String message){
        super();
        this.message = message;
    }
}
