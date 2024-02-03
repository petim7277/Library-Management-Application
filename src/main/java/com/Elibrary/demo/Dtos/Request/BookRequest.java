package com.Elibrary.demo.Dtos.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequest {

    private  String bookTitle ;
    private  String bookAuthor ;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;
    private  String username;
    private String category;


}
