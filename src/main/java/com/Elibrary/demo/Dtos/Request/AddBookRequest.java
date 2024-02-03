package com.Elibrary.demo.Dtos.Request;

import lombok.Data;

@Data
public class AddBookRequest {
    private  String bookTitle ;
    private  String bookAuthor ;
    private  String yearOfPublication ;
}
