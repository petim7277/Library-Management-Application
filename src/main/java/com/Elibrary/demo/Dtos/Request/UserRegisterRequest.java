package com.Elibrary.demo.Dtos.Request;
import lombok.Data;

@Data
public class UserRegisterRequest {

    private String userEmail;
    private String userName;
    private String userPassword;
}
