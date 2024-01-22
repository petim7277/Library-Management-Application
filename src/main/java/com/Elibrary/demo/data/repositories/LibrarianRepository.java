package com.Elibrary.demo.data.repositories;

import com.Elibrary.demo.data.models.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrarianRepository extends MongoRepository<Librarian,String> {
   Librarian findByLibrarianName(String librarianName);



}
