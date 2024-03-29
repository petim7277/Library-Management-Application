package com.Elibrary.demo.data.repositories;

import com.Elibrary.demo.data.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Books,String> {
    Books findByBookTitle(String bookName);
    Books findByBookTitleAndBookAuthor(String bookTitle, String bookAuthor);

    Books findByBookTitleAndId(String bookTitle,String bookId);
}
