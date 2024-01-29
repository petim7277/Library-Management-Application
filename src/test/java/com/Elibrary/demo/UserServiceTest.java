package com.Elibrary.demo;

import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.repositories.UserRepository;
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
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setName("precious");
        userRegisterRequest.setEmail("petim7277@gmail.com");
        userService.register(userRegisterRequest);
        assertThrows(UserExistException.class, ()-> userService.register(userRegisterRequest));
    }

    @Test
    public void testThat_AUserCanRegisterTest()  {
        RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setName("precious");
        userRegisterRequest.setEmail("petim7277@gmail.com");
        userService.register(userRegisterRequest) ;
        assertThrows(UserExistException.class, ()-> userService.register(userRegisterRequest));
    }

    @Test
    public void testThatTheSame_UserCanRegisterAgainTest()  {
       RegisterRequest userRegisterRequest = new RegisterRequest();
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setName("precious");
        userRegisterRequest.setEmail("petim7277@gmail.com");
        assertThrows(UserExistException.class, ()-> userService.register(userRegisterRequest));
    }




}
