package com.Elibrary.demo.Exceptions;

public class InvalidUsernameException extends RuntimeException{
    public InvalidUsernameException(){
        super();
    }
    public InvalidUsernameException(String message){
        super(message);
    }
    public InvalidUsernameException(String message, Throwable cause){
        super(message,cause);
    }
}
