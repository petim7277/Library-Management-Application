package com.Elibrary.demo.services.Librarian;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;


public interface LibrarianService  {
   Librarian register(RegisterRequest registerRequest) ;
      void logIn(LoginRequest loginRequest) ;
   boolean checkBookAvailability(BookRequest bookRequest);
      void lendBooks(BookRequest lendBookRequest,LoginRequest loginRequest);
}
