package com.Elibrary.demo.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class User {
    @Id
    private  String userId;
    private  String  userName;
    private  String  userPassword ;
    private  String  userEmail;
    public User() {

    }
}
