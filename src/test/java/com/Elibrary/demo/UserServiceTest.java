package com.Elibrary.demo;

import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.*;
import com.Elibrary.demo.data.repositories.UserRepository;
import com.Elibrary.demo.services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;
    @BeforeEach
    public void doThisBeforeEachTest(){
       // userRepository.deleteAll();
    }
    @AfterEach
    public void doThisAfterEachTest(){
       // userRepository.deleteAll();
    }


    @Test
    public void testThatA_UserCanRegisterTest()  {
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setName("cherish");
        userRegisterRequest.setPassword("prec,1234");
        userRegisterRequest.setEmail("cherry7277@gmail.com");
        userService.register(userRegisterRequest);
    }

    @Test
    public void testThatA_UserCanRegister_WithWrongUsername_Test()  {
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setName("@cherish");
        userRegisterRequest.setPassword("prec,1234");
        userRegisterRequest.setEmail("cherry7277@gmail.com");
        assertThrows(InvalidUsernameException.class,()->userService.register(userRegisterRequest));
    }

    @Test
    public void testThatA_UserCanRegister_WithWrongPassword_Test()  {
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setName("jael");
        userRegisterRequest.setPassword("prec,1234][");
        userRegisterRequest.setEmail("cherry7277@gmail.com");
        assertThrows(InvalidPasswordException.class,()->userService.register(userRegisterRequest));
    }

    @Test
    public void testThatA_UserCanRegister_WithWrongEmail_Test()  {
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setName("jael");
        userRegisterRequest.setPassword("prec,1234");
        userRegisterRequest.setEmail("cherry7277gmail.com");
        assertThrows(InvalidEmailException.class,()->userService.register(userRegisterRequest));
    }

    @Test
    public void testThatA_UserThatHasRegistered_CanRegisterAgainTest()  {
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setName("cherish");
        userRegisterRequest.setPassword("prec,1234");
        userRegisterRequest.setEmail("cherry7277@gmail.com");
        assertThrows(UserExistException.class,()->userService.register(userRegisterRequest)) ;
    }
    @Test
    public void testThatARegistered_UserCanLoginTest()  {
       LoginRequest loginRequest = new LoginRequest();
        loginRequest.setName("cherish");
        loginRequest.setPassword("prec,1234");
        loginRequest.setEmail("cherry7277@gmail.com");
        userService.login(loginRequest);
    }

    @Test
    public  void  testThatAnUnregistered_UserCanLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setName("jonathan");
        loginRequest.setPassword("jona,1234");
        loginRequest.setEmail("jona7277@gmail.com");
        assertThrows(UserExistException.class,()->userService.login(loginRequest));
         
    }



}
