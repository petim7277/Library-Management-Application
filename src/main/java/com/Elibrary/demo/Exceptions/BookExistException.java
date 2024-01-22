package com.Elibrary.demo.Exceptions;

public class BookExistException extends  RuntimeException{
    public BookExistException(){
        super();
    }
    public BookExistException(String message){
        super(message);
    }

    public BookExistException(String message,Throwable cause){
        super(message, cause);
    }
}
