package com.Elibrary.demo.services.User;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.*;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.User;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.UserRepository;
import com.Elibrary.demo.services.Librarian.LibrarianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static com.Elibrary.demo.Utils.Mapper.userRegisterMapper;
import static com.Elibrary.demo.Utils.Validator.*;
 @AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private LibrarianService librarianService;
    private  UserRepository userRepository;
    private BookRepository bookRepository;
    //private BookCategory bookCategory;

     @Override
     public User register(RegisterRequest registerRequest)  {
          if (checkIfUserAlreadyExist(registerRequest.getName()))
              throw new UserExistException("User Already exist " + registerRequest.getName());
          User user = userRegisterMapper("UID"+userRepository.count()+1,registerRequest.getName(),registerRequest.getPassword(),registerRequest.getEmail());
          handleEmptyFieldsForUser(registerRequest);
         validator(registerRequest);
        return userRepository.save(user);
     }
     @Override
     public void login(LoginRequest loginRequest) {
        if (!checkIfUserAlreadyExist(loginRequest.getName()))
            throw new UserExistException("User Does not exist");
        User user = userRepository.findByUserName(loginRequest.getName());
        handleEmptyFieldsForUser(loginRequest);
        checkUserData(loginRequest);
         userRepository.save(user);
     }

     @Override
     public void searchForGenreBooks(BookRequest searchBookRequest,LoginRequest loginRequest) {
         if (!checkIfUserAlreadyExist(loginRequest.getName()))
             throw new UserExistException("User Does not exist");
         Books foundBook = bookRepository.findByBookTitleAndBookAuthor(searchBookRequest.getBookTitle(), searchBookRequest.getBookAuthor());
         if (foundBook == null) {
             throw new BookExistException("Book Does Not Exist");
         }
      
     }

     @Override
     public Books borrowBook(BookRequest bookRequest) {
         Books foundBook = bookRepository.findByBookTitleAndBookAuthor(bookRequest.getBookTitle(), bookRequest.getBookAuthor());
         if (foundBook == null) {
             throw new BookExistException("Book Does Not Exist");
         }
        return  null;
                //librarianService.lendBooks(bookRequest);
     }

     @Override
     public void returnBook(BookRequest bookRequest) {

     }

     public  void validateUserExistence(RegisterRequest registerRequest){
         User user = userRegisterMapper("UID"+userRepository.count()+1,registerRequest.getName(),registerRequest.getPassword(),registerRequest.getEmail());
         if (!user.getUserName().equals(registerRequest.getName())) throw  new UserExistException("User May Not Exist") ;
         if (!user.getUserEmail().equals(registerRequest.getEmail())) throw  new UserExistException("User May Not Exist") ;
         if (!user.getUserPassword().equals(registerRequest.getPassword())) throw  new UserExistException("User May Not Exist");
     }

     public void validator (RegisterRequest registerRequest) {
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
     public  void  handleEmptyFieldsForUser(RegisterRequest registerRequest) {
         if (registerRequest.getName().trim().isEmpty()){
             throw new UsernameFieldIsEmptyException("Username field must not be empty") ;
         }
         if (registerRequest.getPassword().trim().isEmpty()){
             throw  new PasswordFieldIsEmptyException("Password field cannot be empty");
         }
         if (registerRequest.getEmail().trim().isEmpty()){
             throw new EmailFieldIsEmptyException("Email field must not be empty") ;
         }
     }

     public  void checkUserData (LoginRequest loginRequest) {
         User foundUser = userRepository.findByUserName(loginRequest.getName());

         if (!foundUser.getUserName().equals(loginRequest.getName())) {
             throw new InvalidDetailsException("Invalid Details [Username does not match]");
         }

         if (!foundUser.getUserEmail().equals(loginRequest.getEmail())) {
             throw new InvalidDetailsException("Invalid Details[Email does not match] ");
         }

         if (!foundUser.getUserPassword().equals(loginRequest.getPassword())) {
             throw new InvalidDetailsException("Invalid Details[Password not match]");
         }

     }
     public  void  handleEmptyFieldsForUser(LoginRequest loginRequest){
         if (loginRequest.getName().trim().isEmpty()) {
             throw new UsernameFieldIsEmptyException("Username field must not be empty");
         }
         if (loginRequest.getPassword().trim().isEmpty()) {
             throw new PasswordFieldIsEmptyException("Password field must not be empty");
         }
         if (loginRequest.getEmail().trim().isEmpty()) {
             throw new EmailFieldIsEmptyException("Email field must not be empty");
         }
     }

     public boolean checkIfUserAlreadyExist(String userName){
         User user = userRepository.findByUserName(userName);
         return user != null;
     }


 }
