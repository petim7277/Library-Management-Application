package com.Elibrary.demo.Exceptions;

public class UsernameFieldIsEmptyException extends RuntimeException {
    public  UsernameFieldIsEmptyException (){
        super();
    }
    public  UsernameFieldIsEmptyException(String message){
        super(message);
    }
    public  UsernameFieldIsEmptyException(String message,Throwable cause){
        super(message,cause);
    }
}
