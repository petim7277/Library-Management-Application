package com.Elibrary.demo.Exceptions;

public class PasswordFieldIsEmptyException extends RuntimeException {

    public PasswordFieldIsEmptyException(){
        super();
    }

    public PasswordFieldIsEmptyException(String message){
        super(message);
    }

    public PasswordFieldIsEmptyException(String message,Throwable cause){
        super(message);
    }
}
