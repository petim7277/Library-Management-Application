package com.Elibrary.demo.services.User;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidUsernameException;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.User;

public interface UserService {
    User register(RegisterRequest registerRequest) ;
    void login (LoginRequest loginRequest)throws InvalidUsernameException;

    void searchForGenreBooks(BookRequest searchBookRequest,LoginRequest loginRequest);
    Books borrowBook(BookRequest bookRequest);
    void returnBook(BookRequest bookRequest);

}
