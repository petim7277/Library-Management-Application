package com.Elibrary.demo.data.repositories;

import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Books,String> {
    Books findByBookTitleAndBookAuthor(String bookTitle, String bookAuthor);
    Books findByBookTitle(String bookTitle);

    Books findByBookTitleAndUsername(String bookTitle,String username);
}
