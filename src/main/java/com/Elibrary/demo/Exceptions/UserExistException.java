package com.Elibrary.demo.Exceptions;

public class UserExistException extends RuntimeException{
    public UserExistException(){
        super();
    }
    public UserExistException(String message){
        super(message);
    }
    public UserExistException(String message,Throwable cause){
        super(message,cause);
    }
}
