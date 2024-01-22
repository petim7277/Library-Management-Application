package com.Elibrary.demo.services;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianLoginRequest;
import com.Elibrary.demo.Dtos.Request.UserRegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidDetailsException;
import com.Elibrary.demo.data.models.User;

public interface UserService {
    User register(UserRegisterRequest registerRequest) ;
    User login (LibrarianLoginRequest loginRequest)throws InvalidDetailsException;

    void searchForPopularBooks();
    void borrowBook(BookRequest bookRequest);
    void returnBook(BookRequest bookRequest);

}
