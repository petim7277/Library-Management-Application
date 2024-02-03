package com.Elibrary.demo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Library {
    private LocalDateTime dateAndTime;
    private List<Books> listOfBooks;
}
