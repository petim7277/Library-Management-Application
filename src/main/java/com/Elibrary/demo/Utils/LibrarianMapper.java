package com.Elibrary.demo.Utils;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianLoginRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianRegisterRequest;
import com.Elibrary.demo.data.models.Books;
import com.Elibrary.demo.data.models.Librarian;

public class LibrarianMapper {

        public static Librarian registerMap(LibrarianRegisterRequest registerRequest){
            Librarian newLibrarian = new Librarian();

            newLibrarian.setLibrarianName(registerRequest.getName());
            newLibrarian.setLibrarianPassword(registerRequest.getPassword());
            newLibrarian.setLibrarianEmail(registerRequest.getEmail());
            return newLibrarian;
        }

    public static Librarian loginMap(LibrarianLoginRequest loginRequest){
        Librarian newLibrarian = new Librarian();
        newLibrarian.setLibrarianName(loginRequest.getName());
        newLibrarian.setLibrarianPassword(loginRequest.getPassword());
        newLibrarian.setLibrarianEmail(loginRequest.getEmail());
        return newLibrarian;
    }


    }

