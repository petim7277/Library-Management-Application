package com.Elibrary.demo.services;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidUsernameException;
import com.Elibrary.demo.data.models.User;

public interface UserService {
    User register(RegisterRequest registerRequest) ;
    User login (LoginRequest loginRequest)throws InvalidUsernameException;

    void searchForPopularBooks();
    void borrowBook(BookRequest bookRequest);
    void returnBook(BookRequest bookRequest);

}
