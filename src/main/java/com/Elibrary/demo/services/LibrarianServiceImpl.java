package com.Elibrary.demo.services;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianLoginRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianRegisterRequest;
import com.Elibrary.demo.Exceptions.BookExistException;
import com.Elibrary.demo.Exceptions.InvalidBookException;
import com.Elibrary.demo.Exceptions.InvalidDetailsException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibrarianRepository;
import com.Elibrary.demo.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.Elibrary.demo.Utils.BookMapper.bookMap;
import static com.Elibrary.demo.Utils.LibrarianMapper.*;
import static com.Elibrary.demo.Utils.Validator.*;

@AllArgsConstructor
@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
     private LibrarianRepository librarianRepository ;
    @Autowired
     private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
     public Librarian register(LibrarianRegisterRequest registerRequest)  {
        if (checkIfLibrarianExist(registerRequest.getName()))
            throw new UserExistException(" User Already Exists "+ registerRequest.getName());
        Librarian librarian = registerMap(registerRequest);
       return  librarianRepository.save(librarian) ;
    }
     @Override
     public Librarian logIn(LibrarianLoginRequest loginRequest)  {
        Librarian foundLibrarian = librarianRepository.findByLibrarianName(loginRequest.getName());
         if (!checkIfLibrarianExist(loginRequest.getName()))
             throw new InvalidDetailsException("This Librarian Does not exist") ;
         if (!foundLibrarian.getLibrarianPassword().equalsIgnoreCase(loginRequest.getPassword()))
             throw  new InvalidDetailsException("Invalid details");

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

        Books books = bookMap(bookRequest) ;
        if (!books.getBookTitle().equals(books.getBookTitle())) {
            throw new BookExistException("Book may not Exist based on title");
        }
        else if (!books.getBookAuthor().equals(books.getBookAuthor())) {
            throw new BookExistException("Book May Not Exist based on Author");
        }
        else if (!books.getYearOfPublication().equals(books.getYearOfPublication())) {
            throw new BookExistException("Book May Not Exist based on Year of publication");
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

    public  void checkUserData (){
        LibrarianLoginRequest loginRequest = new LibrarianLoginRequest();
        Librarian foundLibrarian = librarianRepository.findByLibrarianName(loginRequest.getName());
        if(!foundLibrarian.getLibrarianName().equals(loginRequest.getName())) {
            throw new InvalidDetailsException("Librarian Name  not found");
        }
        if(!foundLibrarian.getLibrarianEmail().equals(loginRequest.getEmail())) {
            throw new InvalidDetailsException("Email not found");
        }
        if(!foundLibrarian.getLibrarianPassword().equals(loginRequest.getPassword())) {
            throw new InvalidDetailsException("password not found");
        }
    }

    public  void validateUserExistence(){
        LibrarianLoginRequest loginRequest = new LibrarianLoginRequest();
        Librarian librarian = loginMap(loginRequest);
        if (!librarian.getLibrarianName().equals(loginRequest.getName())) throw  new UserExistException("User May Not Exist") ;
        if (!librarian.getLibrarianEmail().equals(loginRequest.getEmail())) throw  new UserExistException("User May Not Exist") ;
        if (!librarian.getLibrarianPassword().equals(loginRequest.getPassword())) throw  new UserExistException("User May Not Exist");
    }

    public void validator () {
        LibrarianRegisterRequest registerRequest = new LibrarianRegisterRequest();

        validatePassword(registerRequest.getPassword());
        validateEmail(registerRequest.getEmail());
        validateName(registerRequest.getName()) ;

    }

    public  boolean checkIfLibrarianExist(String librarianName){
        Librarian  librarian = librarianRepository.findByLibrarianName(librarianName);
        return librarian !=null;
    }



    public  boolean checkIfBookExist(String book){
        Books books =new Books();
        return books != null;
    }

 }
