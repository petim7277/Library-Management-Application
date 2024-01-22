package com.Elibrary.demo.Utils;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.data.models.Books;

public class BookMapper {
    public static Books bookMap(BookRequest bookRequest){
        Books books = new Books();
        books.setBookTitle(bookRequest.getBookTitle());
        books.setBookAuthor(bookRequest.getBookAuthor());
        books.setYearOfPublication(bookRequest.getYearOfPublication());
        return books;
    }
}
