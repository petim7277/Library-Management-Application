package com.Elibrary.demo.services.Admin;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.data.models.Admin;
import com.Elibrary.demo.data.models.AdminRole;
import com.Elibrary.demo.data.models.BookCategory;
import com.Elibrary.demo.data.repositories.AdminRepository;

public interface AdminService  {
    Admin register(RegisterRequest registerRequest);
    void  login (LoginRequest loginRequest);
    void addBookToLibrary(BookRequest bookRequest, AdminRole adminRole);
    int countExistingBooks (BookRequest bookRequest, BookCategory bookCategory) ;
    void  checkAvailableBooks(BookRequest bookRequest,BookCategory bookCategory, AdminRole adminRole);
    
}
