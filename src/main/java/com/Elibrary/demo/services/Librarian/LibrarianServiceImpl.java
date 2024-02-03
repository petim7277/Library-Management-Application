package com.Elibrary.demo.services.Librarian;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.*;
import com.Elibrary.demo.Utils.Mapper;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.models.User;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibrarianRepository;
import com.Elibrary.demo.data.repositories.LibraryRepository;
import com.Elibrary.demo.data.repositories.UserRepository;
import com.Elibrary.demo.services.Librarian.LibrarianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.Elibrary.demo.Utils.Mapper.*;
import static com.Elibrary.demo.Utils.Validator.*;

@AllArgsConstructor
@Service
public class LibrarianServiceImpl implements LibrarianService {
    private LibrarianRepository librarianRepository ;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private LibraryRepository libraryRepository;

    @Override
     public Librarian register( RegisterRequest registerRequest)  {
        if (checkIfLibrarianExist(registerRequest.getName()))
            throw new UserExistException(" User Already Exists "+ registerRequest.getName());
        Librarian librarian = librarianRegisterMapper("LID"+librarianRepository.count()+1,registerRequest.getName(),registerRequest.getPassword(), registerRequest.getEmail());
       validator(registerRequest);
       return librarianRepository.save(librarian);
    }
     @Override
     public void logIn(LoginRequest loginRequest)  {
         if (!checkIfLibrarianExist(loginRequest.getName()))
             throw new UserExistException("This Librarian Does not exist");
         Librarian foundLibrarian = librarianRepository.findByLibrarianName(loginRequest.getName());
         handleEmptyFieldsForLogin(loginRequest);
         checkUserData(loginRequest);

         librarianRepository.save(foundLibrarian);
     }



    @Override
    public boolean checkBookAvailability(BookRequest bookRequest) {
        Books book = bookRepository.findByBookTitleAndBookAuthor(bookRequest.getBookTitle(),bookRequest.getBookAuthor());
            if (book == null){
                throw new BookExistException("Book is Unavailable") ;
            }
          return  book != null;
    }

    @Override
    public void lendBooks(BookRequest lendBookRequest,LoginRequest loginRequest)  {
        //Book should have a field called
        User user = userRepository.findByUserName(lendBookRequest.getUsername());
        if (!checkIfUserAlreadyExist(loginRequest.getName()))
            throw new UserExistException("User Does not exist");
        Books  findBooks = libraryRepository.findByBookTitleAndBookAuthor(lendBookRequest.getBookTitle(),lendBookRequest.getBookAuthor());
        if(findBooks == null){
            throw new BookExistException("Book Does Not Exist") ;
        }
        Books lendBook = Mapper.lendBookMapper(lendBookRequest.getBookTitle(), lendBookRequest.getBookAuthor(), LocalDateTime.now(),lendBookRequest.getDateReturned());
        lendBook.setBorrowed(true);
       libraryRepository.delete(findBooks); ;
    }

    public  void checkUserData (LoginRequest loginRequest){
        Librarian foundLibrarian = librarianRepository.findByLibrarianName(loginRequest.getName());

        if(!foundLibrarian.getLibrarianName().equals(loginRequest.getName())) {
            throw new InvalidDetailsException("Invalid Details [Username does not match]");
        }
        if(!foundLibrarian.getLibrarianEmail().equals(loginRequest.getEmail())) {
            throw new InvalidDetailsException("Invalid Details[Email does not match] ");
        }
        if(!foundLibrarian.getLibrarianPassword().equals(loginRequest.getPassword())) {
            throw new InvalidDetailsException("Invalid Details[Password not match]");
        }

    }
    public void handleEmptyFieldsForRegister(RegisterRequest registerRequest){
        if (registerRequest.getName().trim().isEmpty()){
            throw new UsernameFieldIsEmptyException("Username field must not be empty") ;
        }
        if (registerRequest.getEmail().trim().isEmpty()){
            throw new EmailFieldIsEmptyException("Email field must not be empty") ;
        }
        if (registerRequest.getPassword().trim().isEmpty()){
            throw new PasswordFieldIsEmptyException("Password field must not be empty") ;
        }
    }
    public void handleEmptyFieldsForLogin(LoginRequest loginRequest){
        if (loginRequest.getName().trim().isEmpty()){
            throw new UsernameFieldIsEmptyException("Username field must not be empty") ;
        }
        if (loginRequest.getEmail().trim().isEmpty()){
            throw new EmailFieldIsEmptyException("Email field must not be empty") ;
        }
        if (loginRequest.getPassword().trim().isEmpty()){
            throw new PasswordFieldIsEmptyException("Password field must not be empty") ;
        }
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

    public  boolean checkIfLibrarianExist(String librarianName){
        Librarian  librarian = librarianRepository.findByLibrarianName(librarianName);
         return librarian != null;
    }

    public boolean checkIfUserAlreadyExist(String userName){
        User user = userRepository.findByUserName(userName);
        return user != null;
    }

    public  boolean checkIfBookExist(String bookTitle,String bookAuthor){
        Books books = libraryRepository.findByBookTitleAndBookAuthor(bookTitle,bookAuthor) ;
        return books != null;
       
    }

 }
