package com.Elibrary.demo.Dtos.Request;
import lombok.Data;

@Data
public class LoginRequest {
    private String name;
    private String email;
    private String password;
}
