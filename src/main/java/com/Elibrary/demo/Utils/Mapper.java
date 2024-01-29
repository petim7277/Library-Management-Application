package com.Elibrary.demo.Utils;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.models.User;

public class Mapper {

        public static Librarian librarianRegisterMapper(RegisterRequest registerRequest){
            Librarian newLibrarian = new Librarian();
            newLibrarian.setLibrarianName(registerRequest.getName());
            newLibrarian.setLibrarianPassword(registerRequest.getPassword());
            newLibrarian.setLibrarianEmail(registerRequest.getEmail());
            return newLibrarian;
        }

    public static Librarian librarianLoginMapper(LoginRequest loginRequest){
        Librarian newLibrarian = new Librarian();
        newLibrarian.setLibrarianName(loginRequest.getName());
        newLibrarian.setLibrarianPassword(loginRequest.getPassword());
        newLibrarian.setLibrarianEmail(loginRequest.getEmail());
        return newLibrarian;
    }

    public static User userRegisterMapper(RegisterRequest RegisterRequest){
        User user = new User();
        user.setUserName(RegisterRequest.getName());
        user.setUserPassword(RegisterRequest.getPassword());
        user.setUserEmail(RegisterRequest.getEmail());
        return user;
    }
    public static User userLoginMapper(LoginRequest RegisterRequest){
        User user = new User();
        user.setUserName(RegisterRequest.getName());
        user.setUserPassword(RegisterRequest.getPassword());
        user.setUserEmail(RegisterRequest.getEmail());
        return user;
    }

    }

