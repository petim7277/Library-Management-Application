package com.Elibrary.demo.services;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.*;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibrarianRepository;
import com.Elibrary.demo.data.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.Elibrary.demo.Utils.BookMapper.bookMap;
import static com.Elibrary.demo.Utils.Mapper.*;
import static com.Elibrary.demo.Utils.Validator.*;

@AllArgsConstructor
@Service
public class LibrarianServiceImpl implements LibrarianService {
    private LibrarianRepository librarianRepository ;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Override
     public Librarian register( RegisterRequest registerRequest)  {
        if (checkIfLibrarianExist(registerRequest.getName()))
            throw new UserExistException(" User Already Exists "+ registerRequest.getName());
        Librarian librarian = librarianRegisterMapper(registerRequest);
       validator(registerRequest);
       return  librarianRepository.save(librarian) ;
    }
     @Override
     public Librarian logIn(LoginRequest loginRequest)  {
         if (!checkIfLibrarianExist(loginRequest.getName()))
             throw new UserExistException("This Librarian Does not exist");
         Librarian foundLibrarian = librarianRepository.findByLibrarianName(loginRequest.getName());
         checkUserData(loginRequest);

         return librarianRepository.save(foundLibrarian);
     }

    @Override
    public Books addBooks(BookRequest lendBookRequest)  {
        if (checkIfBookExist(lendBookRequest.getBookTitle())) {
            throw new BookExistException(" Book Already Exists " + lendBookRequest.getBookTitle());
        }
        Books books = bookMap(lendBookRequest);

        return bookRepository.save(books);
    }

    @Override
    public boolean checkBookAvailability(BookRequest bookRequest) {
        Books bookTitle = bookRepository.findByBookTitle(bookRequest.getBookTitle());
        Books bookAuthor = bookRepository.findByBookAuthor(bookRequest.getBookAuthor());
       Books books = bookMap(bookRequest) ;
        if (!books.getBookTitle().equalsIgnoreCase(bookRequest.getBookTitle())) {
            throw new BookExistException("Book may not Exist based on title");
        }
        else if (!books.getBookAuthor().equalsIgnoreCase(bookRequest.getBookAuthor())) {
            throw new BookExistException("Book May Not Exist based on Author");
        }

        else
        return true;
    }

    @Override
    public Books lendBooks(BookRequest lendBookRequest)  {
        Books foundBooks = new Books();
     if(!checkIfBookExist(lendBookRequest.getBookTitle())){
       throw new BookExistException("Book May not exist") ;
     }
       return bookRepository.save(foundBooks) ;
    }

    public  void checkUserData (LoginRequest loginRequest){
        Librarian foundLibrarian = librarianRepository.findByLibrarianName(loginRequest.getName());

        if(!foundLibrarian.getLibrarianName().equals(loginRequest.getName())) {
            throw new InvalidDetailsException("Invalid Details [Username does not match]");
        }
        if (loginRequest.getName().trim().isEmpty()){
            throw new UsernameFieldIsEmptyException("Username field must not be empty") ;
        }
        if(!foundLibrarian.getLibrarianEmail().equals(loginRequest.getEmail())) {
            throw new InvalidDetailsException("Invalid Details[Email does not match] ");
        }
        if (loginRequest.getEmail().trim().isEmpty()){
            throw new EmailFieldIsEmptyException("Email field must not be empty") ;
        }
        if(!foundLibrarian.getLibrarianPassword().equals(loginRequest.getPassword())) {
            throw new InvalidDetailsException("Invalid Details[Password not match]");
        }
        if (loginRequest.getPassword().trim().isEmpty()){
            throw new PasswordFieldIsEmptyException("Password field must not be empty") ;
        }
    }

    public  void validateUserExistence(LoginRequest loginRequest){
        Librarian librarian = librarianLoginMapper(loginRequest);
        if (!librarian.getLibrarianName().equals(loginRequest.getName())) throw  new UserExistException("User May Not Exist") ;
        if (!librarian.getLibrarianEmail().equals(loginRequest.getEmail())) throw  new UserExistException("User May Not Exist") ;
        if (!librarian.getLibrarianPassword().equals(loginRequest.getPassword())) throw  new UserExistException("User May Not Exist");
    }

    public void validator (RegisterRequest registerRequest) {
        if (registerRequest.getName().trim().isEmpty()){
            throw new UsernameFieldIsEmptyException("Username field must not be empty") ;
        }
       if (!validateName(registerRequest.getName())){
           throw new InvalidUsernameException("Invalid Username") ;
       }
        if (registerRequest.getPassword().trim().isEmpty()){
            throw  new PasswordFieldIsEmptyException("Password field cannot be empty");
        }
        if (!validatePassword(registerRequest.getPassword())){
            throw new InvalidPasswordException("Invalid Password") ;
        }
        if (registerRequest.getEmail().trim().isEmpty()){
            throw new EmailFieldIsEmptyException("Email field must not be empty") ;
        }
        if (!validateEmail(registerRequest.getEmail())){
            throw new InvalidEmailException("Invalid Email");
        }

    }

    public  boolean checkIfLibrarianExist(String librarianName){
        Librarian  librarian = librarianRepository.findByLibrarianName(librarianName);
         return librarian != null;
    }



    public  boolean checkIfBookExist(String bookTitle){
        Books books = bookRepository.findByBookTitle(bookTitle) ;
        return books != null;
    }

 }
