package com.Elibrary.demo.data.repositories;

import com.Elibrary.demo.data.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin,String> {


    Admin findByAdminName(String adminName);
}
