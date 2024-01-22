package com.Elibrary.demo.services;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianLoginRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianRegisterRequest;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;


public interface LibrarianService {
   Librarian register(LibrarianRegisterRequest registerRequest) ;
      Librarian logIn(LibrarianLoginRequest loginRequest) ;
      Books addBooks(BookRequest lendBookRequest);
      boolean checkBookAvailability(BookRequest bookRequest);
      Books lendBooks(BookRequest lendBookRequest);
}
