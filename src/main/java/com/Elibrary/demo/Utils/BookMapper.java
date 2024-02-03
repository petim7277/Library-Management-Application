package com.Elibrary.demo.Utils;

import com.Elibrary.demo.Dtos.Request.AddBookRequest;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.data.models.Books;

public class BookMapper {
    public static Books bookMap(AddBookRequest addBookRequest){
        Books books = new Books();
        books.setBookTitle(addBookRequest.getBookTitle());
        books.setBookAuthor(addBookRequest.getBookAuthor());
        books.setYearOfPublication(addBookRequest.getYearOfPublication());
        return books;
    }
}
