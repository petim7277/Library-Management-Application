package com.Elibrary.demo.Exceptions;

public class InvalidDetailsException extends RuntimeException{
    public InvalidDetailsException(){
        super();
    }
    public InvalidDetailsException(String message){
        super(message);
    }
    public InvalidDetailsException(String message,Throwable cause){
        super(message,cause);
    }
}
