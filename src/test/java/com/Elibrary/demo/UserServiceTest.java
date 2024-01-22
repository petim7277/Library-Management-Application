package com.Elibrary.demo;

import com.Elibrary.demo.Dtos.Request.UserRegisterRequest;

import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.repositories.UserRepository;
import com.Elibrary.demo.services.UserService;
import com.Elibrary.demo.services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class UserServiceTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;
    @AfterEach
    public void doThisAfterEachTest(){
        //userRepository.deleteAll();
    }


    @Test
    public void testThatA_UserIRegister_AUserTwice_AnExceptionIsThrown_Test()  {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUserPassword("password");
        userRegisterRequest.setUserName("precious");
        userRegisterRequest.setUserEmail("petim7277@gmail.com");
        userService.register(userRegisterRequest);
        assertThrows(UserExistException.class, ()-> userService.register(userRegisterRequest));
    }

    @Test
    public void testThat_AUserCanRegisterTest()  {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUserPassword("password");
        userRegisterRequest.setUserName("precious");
        userRegisterRequest.setUserEmail("petim7277@gmail.com");
        userService.register(userRegisterRequest) ;
        assertThrows(UserExistException.class, ()-> userService.register(userRegisterRequest));
    }

    @Test
    public void testThatTheSame_UserCanRegisterAgainTest()  {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUserPassword("password");
        userRegisterRequest.setUserName("precious");
        userRegisterRequest.setUserEmail("petim7277@gmail.com");
        assertThrows(UserExistException.class, ()-> userService.register(userRegisterRequest));
    }




}
