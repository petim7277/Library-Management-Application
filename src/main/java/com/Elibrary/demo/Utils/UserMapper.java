package com.Elibrary.demo.Utils;

import com.Elibrary.demo.Dtos.Request.UserRegisterRequest;
import com.Elibrary.demo.data.models.User;

public class UserMapper {
    public static User mapper(UserRegisterRequest userRegisterRequest){
        User user = new User();

        user.setUserName(userRegisterRequest.getUserName());
        user.setUserPassword(userRegisterRequest.getUserPassword());
        user.setUserEmail(userRegisterRequest.getUserEmail());
        return user;
    }
}
