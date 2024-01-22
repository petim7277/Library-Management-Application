package com.Elibrary.demo.data.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Librarian {
     @Id
    private String librarianId;
    private String librarianName;
    private String librarianEmail;
    private String librarianPassword;
    private LocalDateTime localDateTime = LocalDateTime.now();

}
