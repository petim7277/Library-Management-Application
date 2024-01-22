package com.Elibrary.demo.Dtos.Request;
import lombok.Data;

@Data
public class LibrarianRegisterRequest {

    private String name;
    private String password;
    private String email;


}
