package com.desafio.zappts.magic.services.exceptions;

public class ControllerNotFoundException extends RuntimeException{
    public ControllerNotFoundException(String message){
        super(message);
    }
}
