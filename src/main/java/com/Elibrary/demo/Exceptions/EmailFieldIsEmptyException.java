package com.Elibrary.demo.Exceptions;

public class EmailFieldIsEmptyException extends RuntimeException{
    public EmailFieldIsEmptyException(){
        super();
    }
    public EmailFieldIsEmptyException(String message){
        super(message);
    }

    public EmailFieldIsEmptyException(String message,Throwable cause){
        super(message, cause);
    }
}
