package com.Elibrary.demo.data.models;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class Books {
    @Id
    private  String bookId;
    private  String bookTitle ;
    private  String bookAuthor ;
    private boolean isBorrowed ;
    private LocalDateTime dateBorrowed;
    private LocalDate dateReturned;
    private BookCategory bookCategory;
    private  String username;


}
