package com.Elibrary.demo.Dtos.Request;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String password;
    private String email;


}
