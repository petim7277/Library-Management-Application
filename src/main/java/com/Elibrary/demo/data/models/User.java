package com.Elibrary.demo.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class User {
    private  String  userEmail;
    private  String  userName ;
    private  String  userPassword;
    public User() {

    }
}
