package com.Elibrary.demo.controllers;

import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Dtos.Response.ApiResponse;
import com.Elibrary.demo.Dtos.Response.BookResponse;
import com.Elibrary.demo.Dtos.Response.LibrarianLoginResponse;
import com.Elibrary.demo.Dtos.Response.LibrarianRegisterResponse;
import com.Elibrary.demo.Exceptions.BookExistException;
import com.Elibrary.demo.Exceptions.InvalidUsernameException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.services.LibrarianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/Library-Application/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class LibrarianController {

 private final LibrarianService librarianService;

 @PostMapping("/LibrarianRegister")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest librarianRegisterRequest) {
     LibrarianRegisterResponse registerResponse = new LibrarianRegisterResponse();
     Librarian librarian = null;
     try {
         librarian = librarianService.register(librarianRegisterRequest);
         registerResponse.setRequestResponse("Librarian has been successfully Registered ");
         return new ResponseEntity<>(new ApiResponse(true, librarian, registerResponse.getRequestResponse()),
                 HttpStatus.CREATED);
     } catch (UserExistException userExistException) {
         registerResponse.setRequestResponse(userExistException.getMessage());
         return new ResponseEntity<>(new ApiResponse(false, librarian, registerResponse.getRequestResponse()), HttpStatus.BAD_REQUEST);
     }
 }

 @PostMapping("/LibrarianLogin")
     public ResponseEntity<?> login(@RequestBody LoginRequest librarianLoginRequest) {
     LibrarianLoginResponse librarianLoginResponse = new LibrarianLoginResponse();
     try {
      librarianService.logIn(librarianLoginRequest) ;
      librarianLoginResponse.setRequestResponse("Librarian has been successfully Logged in");
      return new ResponseEntity<>(new ApiResponse(true,librarianLoginResponse, librarianLoginResponse.getRequestResponse()),OK);
     }catch (InvalidUsernameException invalidDetailsException){
         librarianLoginResponse.setRequestResponse(invalidDetailsException.getMessage());
         return new ResponseEntity<>(new ApiResponse(false,librarianLoginResponse,invalidDetailsException.getMessage()),BAD_REQUEST);
     }
 }
@PostMapping("/LibrarianAddBook")
    public ResponseEntity<?> addBook(@RequestBody BookRequest bookRequest){
    BookResponse bookResponse = new BookResponse();
    try {
        librarianService.addBooks(bookRequest);
        bookResponse.setRequestResponse("Book Has been successfully added to Library");
        return new ResponseEntity<>(new ApiResponse(true,bookResponse,bookResponse.getRequestResponse()),OK) ;
    } catch (BookExistException bookExistException) {
 bookResponse.setRequestResponse(bookExistException.getMessage());
 return  new ResponseEntity<>(new ApiResponse(false,bookResponse,bookResponse.getRequestResponse()),BAD_REQUEST);
    }
}
//
//@PostMapping("/LibrarianLendBook")
//    public ResponseEntity<?> lendBook(@RequestBody BookRequest bookRequest){
//     BookResponse = new BookResponse();
//     try {
//         librarianService.lendBooks(bookRequest);
//         bookResponse.setRequestResponse("Book Has Been Successfully lent to User");
//         return new ResponseEntity<>(new ApiResponse(true,bookResponse,bookResponse.getRequestResponse(),OK));
//     } catch (BookExistException bookExistException) {
//        bookResponse.setRequestResponse(bookExistException.getMessage());
//        return new ResponseEntity<>(new ApiResponse(false,bookResponse, bookResponse.getRequestResponse(),BAD_REQUEST));
//     }
//}

   
}
