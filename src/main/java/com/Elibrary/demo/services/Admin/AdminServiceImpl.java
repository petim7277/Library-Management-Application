package com.Elibrary.demo.services.Admin;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidEmailException;
import com.Elibrary.demo.Exceptions.InvalidPasswordException;
import com.Elibrary.demo.Exceptions.InvalidUsernameException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.models.*;
import com.Elibrary.demo.data.repositories.AdminRepository;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

import static com.Elibrary.demo.Utils.Mapper.adminRegisterMapper;
import static com.Elibrary.demo.Utils.Mapper.librarianRegisterMapper;
import static com.Elibrary.demo.Utils.Validator.*;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private LibraryRepository libraryRepository;
    private BookRepository bookRepository;
    private AdminRepository adminRepository;

    @Override
    public Admin register(RegisterRequest registerRequest) {
        if (checkIfAdminExist(registerRequest.getName()))
            throw new UserExistException(" Admin Already Exists "+ registerRequest.getName());
        Admin admin = adminRegisterMapper("ADMIN00"+adminRepository.count()+1,registerRequest.getName(),registerRequest.getPassword(), registerRequest.getEmail());
        validator(registerRequest);
        return adminRepository.save(admin);
        return null;
    }

    @Override
    public void login(LoginRequest loginRequest) {

    }

    @Override
    public void addBookToLibrary(BookRequest bookRequest, AdminRole adminRole) {
        bookRequest.setCategory("romance");
        Books book = new Books();
        book.setBookCategory(BookCategory.valueOf(bookRequest.getCategory().toUpperCase()));

    }

    @Override
    public int countExistingBooks(BookRequest bookRequest, BookCategory bookCategory) {
        return 0;
    }

    @Override
    public void checkAvailableBooks(BookRequest bookRequest, BookCategory bookCategory, AdminRole adminRole) {

    }
   public boolean checkIfAdminExist(String adminName){
    Admin admin = adminRepository.findByAdminName(adminName) ;
    return admin != null;
   }

    public void validator (RegisterRequest registerRequest) {
        handleEmptyFieldsForRegister(registerRequest);
        if (!validateName(registerRequest.getName())){
            throw new InvalidUsernameException("Invalid Username") ;
        }
        if (!validatePassword(registerRequest.getPassword())){
            throw new InvalidPasswordException("Invalid Password") ;
        }
        if (!validateEmail(registerRequest.getEmail())){
            throw new InvalidEmailException("Invalid Email");
        }

    }
}
