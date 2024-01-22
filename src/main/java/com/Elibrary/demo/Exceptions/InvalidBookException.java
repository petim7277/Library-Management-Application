package com.Elibrary.demo.Exceptions;

public class InvalidBookException extends RuntimeException {
    public  InvalidBookException(){
        super();
    }
     public  InvalidBookException(String message){
        super(message);
     }

    public  InvalidBookException(String message,Throwable cause){
        super(message,cause);
    }

}
