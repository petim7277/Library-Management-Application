package com.Elibrary.demo.Exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(){
        super();
    }

    public InvalidEmailException(String message){
        super(message);
    }

    public InvalidEmailException(String message,Throwable cause){
        super(message,cause);
    }
}
