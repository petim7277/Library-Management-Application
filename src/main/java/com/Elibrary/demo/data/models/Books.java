package com.Elibrary.demo.data.models;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Books {
    @Id
    private  String bookTitle ;
    private  String bookAuthor ;
    private  String yearOfPublication ;
}
