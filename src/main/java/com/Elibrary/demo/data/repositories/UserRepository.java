package com.Elibrary.demo.data.repositories;

import com.Elibrary.demo.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUserName (String userName);
}
