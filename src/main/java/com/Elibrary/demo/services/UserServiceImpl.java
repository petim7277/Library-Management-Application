package com.Elibrary.demo.services;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianLoginRequest;
import com.Elibrary.demo.Dtos.Request.UserRegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidDetailsException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.models.User;
import com.Elibrary.demo.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static com.Elibrary.demo.Utils.UserMapper.mapper;
import static com.Elibrary.demo.Utils.Validator.*;
 @AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private  UserRepository userRepository;

     @Override
     public User register(UserRegisterRequest registerRequest)  {
          if (!checkIfUserAlreadyExist(registerRequest.getUserName())) {
              throw new UserExistException("User does not exist ");
          }
          User user = mapper(registerRequest);
         validator();
      return userRepository.save(user);

     }
     @Override
     public User login(LibrarianLoginRequest loginRequest) throws InvalidDetailsException {

         return null;
     }

     @Override
     public void searchForPopularBooks() {

     }

     @Override
     public void borrowBook(BookRequest bookRequest) {

     }

     @Override
     public void returnBook(BookRequest bookRequest) {

     }

     public  void validateUserExistence(){
         UserRegisterRequest registerRequest = new UserRegisterRequest();
         User user = mapper(registerRequest);
         if (!user.getUserName().equals(registerRequest.getUserName())) throw  new UserExistException("User May Not Exist") ;
         if (!user.getUserEmail().equals(registerRequest.getUserEmail())) throw  new UserExistException("User May Not Exist") ;
         if (!user.getUserPassword().equals(registerRequest.getUserPassword())) throw  new UserExistException("User May Not Exist");
     }

     public void validator () {
         UserRegisterRequest registerRequest = new UserRegisterRequest();

         validatePassword(registerRequest.getUserPassword());
         validateEmail(registerRequest.getUserEmail());
         validateName(registerRequest.getUserName()) ;

     }

     public boolean checkIfUserAlreadyExist(String userName){
         User user = new User();
         return true;
     }


 }
