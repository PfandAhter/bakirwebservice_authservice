package com.bws.authservice.exceptions;

import lombok.Getter;

public class UserNotActiveException extends Exception{
    @Getter
    private String message;

    public UserNotActiveException(){
        super();
        this.message = null;
    }

    public UserNotActiveException(String message){
        super();
        this.message = message;
    }

}
