package com.Elibrary.demo.Exceptions;

public class AdminExistException extends  RuntimeException{

    public AdminExistException (){
        super();
    }

    public AdminExistException (String message){
        super(message);
    }

    public AdminExistException (String message,Throwable cause){
        super(message,cause);
    }
}
