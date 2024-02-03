package com.Elibrary.demo.Utils;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.data.models.Admin;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.models.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Mapper {

        public static Librarian librarianRegisterMapper(String librarianId,String librarianName,String librarianPassword,String librarianEmail){
            Librarian newLibrarian = new Librarian();

            newLibrarian.setLibrarianName(librarianName);
            newLibrarian.setLibrarianPassword(librarianPassword);
            newLibrarian.setLibrarianEmail(librarianEmail);
            return newLibrarian;
        }

    public static Librarian librarianLoginMapper(String librarianId,String librarianName,String librarianPassword,String librarianEmail){
        Librarian newLibrarian = new Librarian();

        newLibrarian.setLibrarianName(librarianName);
        newLibrarian.setLibrarianPassword(librarianPassword);
        newLibrarian.setLibrarianEmail(librarianEmail);
        return newLibrarian;
    }

    public static User userRegisterMapper( String userId,String  userName,String userPassword,String userEmail){
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);

        return user;
    }
    public static User userLoginMapper( String userId,String  userName,String  userPassword,String  userEmail){
        User user = new User();
        
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        return user;
    }

    public static Books addBookMapper( String bookId,String  bookTitle,String  bookAuthor,LocalDateTime  dateBorrowed,String dateReturned){
        Books books = new Books();
        books.setBookTitle(bookTitle);
        books.setBookAuthor(bookAuthor);
        books.setDateBorrowed(dateBorrowed);
        return books;
    }

    public static Books lendBookMapper(String  bookTitle, String  bookAuthor, LocalDateTime dateBorrowed, LocalDate dateReturned){
        Books books = new Books();
        books.setBookTitle(bookTitle);
        books.setBookAuthor(bookAuthor);
        books.setDateBorrowed(dateBorrowed);
        books.setDateReturned(dateReturned);
        return books;
    }
    public  static Admin adminRegisterMapper( String adminId,String  adminName,String  adminPassword,String  adminEmail){
     Admin admin = new Admin();
     admin.setAdminId(adminId);
     admin.setAdminName(adminName);
     admin.setAdminPassword(adminPassword);
     admin.setAdminEmail(adminEmail);
     return  admin;
    }
    }

