package com.Elibrary.demo.services;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;


public interface LibrarianService  {
   Librarian register(RegisterRequest registerRequest) ;
      Librarian logIn(LoginRequest loginRequest) ;
      Books addBooks(BookRequest lendBookRequest);
      boolean checkBookAvailability(BookRequest bookRequest);
      Books lendBooks(BookRequest lendBookRequest);
}
