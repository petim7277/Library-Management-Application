package com.Elibrary.demo.services;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidUsernameException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.models.User;
import com.Elibrary.demo.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static com.Elibrary.demo.Utils.Mapper.userRegisterMapper;
import static com.Elibrary.demo.Utils.Validator.*;
 @AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private  UserRepository userRepository;

     @Override
     public User register(RegisterRequest registerRequest)  {
          if (!checkIfUserAlreadyExist(registerRequest.getName())) {
              throw new UserExistException("User does not exist ");
          }
          User user = userRegisterMapper(registerRequest);
         validator();
      return userRepository.save(user);

     }
     @Override
     public User login(LoginRequest loginRequest) throws InvalidUsernameException {

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
         RegisterRequest registerRequest = new RegisterRequest();
         User user = userRegisterMapper(registerRequest);
         if (!user.getUserName().equals(registerRequest.getName())) throw  new UserExistException("User May Not Exist") ;
         if (!user.getUserEmail().equals(registerRequest.getEmail())) throw  new UserExistException("User May Not Exist") ;
         if (!user.getUserPassword().equals(registerRequest.getPassword())) throw  new UserExistException("User May Not Exist");
     }

     public void validator () {
         RegisterRequest registerRequest = new RegisterRequest();

         validatePassword(registerRequest.getPassword());
         validateEmail(registerRequest.getEmail());
         validateName(registerRequest.getName()) ;

     }

     public boolean checkIfUserAlreadyExist(String userName){
         User user = new User();
         return true;
     }


 }
